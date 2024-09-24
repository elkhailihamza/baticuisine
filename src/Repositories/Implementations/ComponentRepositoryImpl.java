package Repositories.Implementations;

import Models.Components;
import Repositories.ComponentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentRepositoryImpl implements ComponentRepository {
    private static Connection connectionInstance;

    public ComponentRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Components findById(Long aLong) {
        Components component = null;
        String sql = "SELECT * FROM components WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    component = this.assignValuesToComponents(rs);
            }
        } catch (SQLException e) {
            System.out.println("Clients Find by id: " + e);
        }
        return component;
    }

    @Override
    public List<Components> fetchAll() {
        List<Components> Components = new ArrayList<>(List.of());
        String sql = "SELECT * FROM components;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Components user = this.assignValuesToComponents(rs);
                Components.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Clients Fetch all err: " + e);
        }
        return Components;
    }

    @Override
    public void save(Components entity) {
        String sql = "INSERT INTO clients (nom, adresse, telephone, estprofessionnel) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignComponentToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients add err: " + e);
        }
    }

    @Override
    public Components saveAndReturn(Components entity) {
        Components component = null;
        String sql = "INSERT INTO clients (nom, adresse, telephone, estprofessionnel) VALUES (?, ?, ?, ?) RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignComponentToStmt(stmt, entity);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                component = this.assignValuesToComponents(rs);
        } catch (SQLException e) {
            System.out.println("Clients add err: " + e);
        }
        return component;
    }

    @Override
    public void update(Components entity) {
        String sql = "UPDATE components SET nom = ?, typecomponent = ?, tauxtva = ?, projetid = ? WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignComponentToStmt(stmt, entity);
            stmt.setLong(6, entity.getComponent_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients update err: "+e);
        }
    }

    @Override
    public Components updateAndReturn(Components entity) {
        Components component = null;
        String sql = "UPDATE components SET nom = ?, typecomponent = ?, tauxtva = ?, projetid = ? WHERE component_id = ? RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignComponentToStmt(stmt, entity);
            stmt.setLong(6, entity.getComponent_id());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                component = this.assignValuesToComponents(rs);
        } catch (SQLException e) {
            System.out.println("Clients update err: "+e);
        }
        return component;
    }

    @Override
    public void delete(Components entity) {
        String sql = "DELETE FROM components WHERE component_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getComponent_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients delete err: "+e);
        }
    }


}
