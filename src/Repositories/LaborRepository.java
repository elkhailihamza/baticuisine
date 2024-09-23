package Repositories;

import Models.Labor;
import Models.Materials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LaborRepository extends GenericRepository<Labor, Long> {
    default void assignLaborToStmt(PreparedStatement stmt, Labor entity) throws SQLException {
        stmt.setLong(1, entity.getComponentId());
        stmt.setDouble(2, entity.getHourlyRate());
        stmt.setDouble(3, entity.getHoursWorked());
        stmt.setDouble(4, entity.getWorkerProductivity());
    }

    default Labor assignValuesToLabor(ResultSet rs) throws SQLException {
        long componentId = rs.getLong("componentId");
        String nom = rs.getString("nom");
        String typeComponent = rs.getString("typecomponent");
        double tauxTVA = rs.getDouble("typecomponent");
        double quantite = rs.getDouble("quantite");
        double coutunitaire = rs.getDouble("coutunitaire");
        double hourlyRate = rs.getDouble("hourlyrate");
        double hoursWorked = rs.getDouble("hoursworked");
        double workerProductivity = rs.getDouble("couttransport");

        return new Labor(componentId, hourlyRate, hoursWorked, workerProductivity);
    }
}
