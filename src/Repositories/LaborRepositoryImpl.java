package Repositories;

import Models.Labor;
import Models.Materials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaborRepositoryImpl implements LaborRepository{
    private static Connection connectionInstance;

    public LaborRepositoryImpl (Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Labor findById(Long aLong) {
        Labor labor = null;
        String sql = "SELECT * FROM labor WHERE componentid = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    labor = this.assignValuesToLabor(rs);
            }
        } catch (SQLException e) {
            System.out.println("Labor Find by id: " + e);
        }
        return labor;
    }

    @Override
    public List<Labor> fetchAll() {
        List<Labor> labors = new ArrayList<>(List.of());
        String sql = "SELECT * FROM labor;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Labor labor = this.assignValuesToLabor(rs);
                labors.add(labor);
            }
        } catch (SQLException e) {
            System.out.println("Labor Fetch all err: " + e);
        }
        return labors;
    }

    @Override
    public void save(Labor entity) {
        String sql = "INSERT INTO labor (componentid, hourlyrate, hoursworked, workerproductivity) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignLaborToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Labor add err: "+e);
        }
    }

    @Override
    public void update(Labor entity) {
        String sql = "UPDATE labor SET componentid = ?, hourlyrate = ?, hoursworked = ?, workerproductivity = ? WHERE componentid = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignLaborToStmt(stmt, entity);
            stmt.setLong(6, entity.getComponentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Labor update err: "+e);
        }
    }

    @Override
    public void delete(Labor entity) {
        String sql = "DELETE FROM labor WHERE componentid = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getComponentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Labor delete err: "+e);
        }
    }
}
