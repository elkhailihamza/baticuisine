package Repositories;

import Models.Labor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LaborRepository extends GenericRepository<Labor, Long> {
    default void assignLaborToStmt(PreparedStatement stmt, Labor entity) throws SQLException {
        stmt.setLong(1, entity.getComponent_id());
        stmt.setDouble(2, entity.getHourlyRate());
        stmt.setDouble(3, entity.getHoursWorked());
        stmt.setDouble(4, entity.getWorkerProductivity());
    }

    default Labor assignValuesToLabor(ResultSet rs) throws SQLException {
        long componentId = rs.getLong("componentId");
        String nom = rs.getString("nom");
        String typeComponent = rs.getString("typecomponent");
        double tauxTVA = rs.getDouble("typecomponent");
        double hourlyRate = rs.getDouble("hourlyrate");
        double hoursWorked = rs.getDouble("hoursworked");
        double workerProductivity = rs.getDouble("couttransport");
        long projetId = rs.getLong("projetid");

        return new Labor(componentId, nom, typeComponent, tauxTVA, hourlyRate, hoursWorked, workerProductivity, projetId);
    }
}
