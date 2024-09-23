package Repositories;

import Models.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    private static Connection connectionInstance;

    public ClientRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Clients findById(Long aLong) {
        Clients user = null;
        String sql = "SELECT * FROM clients WHERE client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    user = this.assignValuesToClients(rs);
            }
        } catch (SQLException e) {
            System.out.println("Clients Find by id: " + e);
        }
        return user;
    }

    @Override
    public List<Clients> fetchAll() {
        List<Clients> Clients = new ArrayList<>(List.of());
        String sql = "SELECT * FROM clients;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Clients user = this.assignValuesToClients(rs);
                Clients.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Clients Fetch all err: " + e);
        }
        return Clients;
    }

    @Override
    public void save(Clients entity) {
        String sql = "INSERT INTO clients (nom, adresse, telephone, estprofessionnel) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignClientToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients add err: "+e);
        }
    }

    @Override
    public Clients saveAndReturn(Clients entity) {
        Clients client = null;
        String sql = "INSERT INTO clients (nom, adresse, telephone, estprofessionnel) VALUES (?, ?, ?, ?) RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignClientToStmt(stmt, entity);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                client = this.assignValuesToClients(rs);
        } catch (SQLException e) {
            System.out.println("Clients add err: "+e);
        }
        return client;
    }

    @Override
    public void update(Clients entity) {
        String sql = "UPDATE clients SET nom = ?, adresse = ?, telephone = ?, estprofessionnel = ? WHERE client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignClientToStmt(stmt, entity);
            stmt.setLong(6, entity.getClient_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients update err: "+e);
        }
    }

    @Override
    public Clients updateAndReturn(Clients entity) {
        Clients client = null;
        String sql = "UPDATE clients SET nom = ?, adresse = ?, telephone = ?, estprofessionnel = ? WHERE client_id = ? RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignClientToStmt(stmt, entity);
            stmt.setLong(6, entity.getClient_id());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                client = this.assignValuesToClients(rs);
        } catch (SQLException e) {
            System.out.println("Clients update err: "+e);
        }
        return client;
    }

    @Override
    public void delete(Clients entity) {
        String sql = "DELETE FROM clients WHERE client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getClient_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients delete err: "+e);
        }
    }

    @Override
    public Clients fetchByNom(String nom) {
        Clients client = null;
        String sql = "SELECT * FROM clients WHERE nom = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setString(1, nom);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    client = this.assignValuesToClients(rs);
            }
        } catch(SQLException e) {
            System.out.println("Clients fetch by nom err: "+e);
        }
        return client;
    }
}
