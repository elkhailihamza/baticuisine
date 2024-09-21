package Repositories;

import Models.Projets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetRepositoryImpl implements ProjetRepository {
    private static Connection connectionInstance;

    public ProjetRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Projets findById(Long aLong) {
        Projets projet = null;
        String sql = "SELECT * FROM projets WHERE projet_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, aLong);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projet = this.assignValuesToProjets(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Projets Find by id: " + e);
        }
        return projet;
    }

    @Override
    public List<Projets> fetchAll() {
        List<Projets> projets = new ArrayList<>();
        String sql = "SELECT * FROM projets;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Projets projet = this.assignValuesToProjets(rs);
                projets.add(projet);
            }
        } catch (SQLException e) {
            System.out.println("Projets Fetch all err: " + e);
        }
        return projets;
    }

    @Override
    public void save(Projets entity) {
        String sql = "INSERT INTO projets (nomprojet, margebeneficiaire, couttotal, etatprojet, clientid) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignProjetToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Projets add err: " + e);
        }
    }

    @Override
    public void update(Projets entity) {
        String sql = "UPDATE projets SET nomprojet = ?, margebeneficiaire = ?, couttotal = ?, etatprojet = ?, clientid = ? WHERE projet_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignProjetToStmt(stmt, entity);
            stmt.setLong(6, entity.getProjet_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Projets update err: " + e);
        }
    }

    @Override
    public void delete(Projets entity) {
        String sql = "DELETE FROM projets WHERE projet_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getProjet_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Projets delete err: " + e);
        }
    }
}