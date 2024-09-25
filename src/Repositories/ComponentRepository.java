package Repositories;

import Models.Components;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ComponentRepository extends GenericRepository<Components, Long> {
    default void assignComponentToStmt(PreparedStatement stmt, Components entity) throws SQLException {
        stmt.setString(1, entity.getNom());
        stmt.setString(2, entity.getTypeComponant());
        stmt.setDouble(3, entity.getTauxTVA());
        stmt.setLong(4, entity.getProjectId());
    }

    default Components assignValuesToComponents(ResultSet rs) throws SQLException {
        long componentId = rs.getLong("component_id");
        String componentNom = rs.getString("nom");
        String componentType = rs.getString("typeComponent");
        double tauxTVA = rs.getDouble("tauxtva");
        long projectId = rs.getLong("projectid");
        return new Components(componentId, componentNom, componentType, tauxTVA, projectId);
    }
}
