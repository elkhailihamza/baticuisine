package Repositories;

import Models.Materials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MaterialRepository extends GenericRepository<Materials, Long> {
    default void assignMaterialToStmt(PreparedStatement stmt, Materials entity) throws SQLException {
        stmt.setLong(1, entity.getComponent_id());
        stmt.setDouble(2, entity.getCoutUnitaire());
        stmt.setDouble(3, entity.getQuantite());
        stmt.setDouble(4, entity.getCoutTransport());
        stmt.setDouble(5, entity.getCoefficientQualite());
    }

    default Materials assignValuesToMaterials(ResultSet rs) throws SQLException {
        long componentId = rs.getLong("componentId");
        String nom = rs.getString("nom");
        String type = rs.getString("typecomponent");
        double tauxTVA = rs.getDouble("tauxtva");
        double coutUnitaire = rs.getDouble("coutunitaire");
        double quantite = rs.getDouble("quantite");
        double coutTransport = rs.getDouble("couttransport");
        double coefficientQualite = rs.getDouble("coefficientqualite");
        long projetId = rs.getLong("projetid");

        return new Materials(componentId, nom, type, tauxTVA, coutUnitaire, quantite, coutTransport, coefficientQualite, projetId);
    }
}
