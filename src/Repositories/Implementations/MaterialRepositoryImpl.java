package Repositories.Implementations;

import Models.Materials;
import Repositories.MaterialRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepositoryImpl implements MaterialRepository {
    private static Connection connectionInstance;

    public MaterialRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Materials findById(Long aLong) {
        Materials material = null;
        String sql = "SELECT * FROM materials WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    material = this.assignValuesToMaterials(rs);
            }
        } catch (SQLException e) {
            System.out.println("Materials Find by id: " + e);
        }
        return material;
    }

    @Override
    public List<Materials> fetchAll() {
        List<Materials> Materials = new ArrayList<>(List.of());
        String sql = "SELECT * FROM materials;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Materials material = this.assignValuesToMaterials(rs);
                Materials.add(material);
            }
        } catch (SQLException e) {
            System.out.println("Materials Fetch all err: " + e);
        }
        return Materials;
    }

    @Override
    public void save(Materials entity) {
        String sql = "INSERT INTO materials (nom, typecomponent, tauxtva, projetid, coutunitaire, quantite, couttransport, coefficientqualite) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignMaterialToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Materials add err: "+e);
        }
    }

    @Override
    public Materials saveAndReturn(Materials entity) {
        Materials material = null;
        String sql = "INSERT INTO materials (nom, typecomponent, tauxtva, projetid, coutunitaire, quantite, couttransport, coefficientqualite) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignMaterialToStmt(stmt, entity);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                material = this.assignValuesToMaterials(rs);
        } catch (SQLException e) {
            System.out.println("Materials add err: "+e);
        }
        return material;
    }

    @Override
    public void update(Materials entity) {
        String sql = "UPDATE materials SET component_id = ?, nom = ?, typecomponent = ?,  tauxtva = ?, coutunitaire = ?, quantite = ?, couttransport = ?, coefficientqualite = ?, projetid = ? WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignMaterialToStmt(stmt, entity);
            stmt.setLong(6, entity.getComponent_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Materials update err: "+e);
        }
    }

    @Override
    public Materials updateAndReturn(Materials entity) {
        Materials material = null;
        String sql = "UPDATE materials SET component_id = ?, nom = ?, typecomponent = ?,  tauxtva = ?, coutunitaire = ?, quantite = ?, couttransport = ?, coefficientqualite = ?, projetid = ? WHERE component_id = ? RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignMaterialToStmt(stmt, entity);
            stmt.setLong(6, entity.getComponent_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                material = this.assignValuesToMaterials(rs);
        } catch (SQLException e) {
            System.out.println("Materials update err: "+e);
        }
        return material;
    }

    @Override
    public void delete(Materials entity) {
        String sql = "DELETE FROM materials WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getComponent_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Materials delete err: "+e);
        }
    }
}
