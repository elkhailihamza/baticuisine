package Repositories;

import Enums.Etat;
import Models.Projets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProjetRepository extends GenericRepository<Projets, Long>{
    default void assignProjetToStmt(PreparedStatement stmt, Projets entity) throws SQLException {
        stmt.setString(1, entity.getNomProjet());
        stmt.setDouble(2, entity.getMargeBeneficiaire());
        stmt.setDouble(3, entity.getCoutTotal());
        stmt.setString(4, entity.getEtatProjet().name());
        stmt.setLong(5, entity.getClientId());
    }

    default Projets assignValuesToProjets(ResultSet rs) throws SQLException {
        long projet_id = rs.getLong("componentId");
        String nomProjet = rs.getString("coutunitaire");
        double margeBeneficiaire = rs.getDouble("quantite");
        double coutTotal = rs.getDouble("couttransport");
        Etat etatProjet = Etat.valueOf(rs.getString("etatprojet"));
        long clientId = rs.getLong("clientid");
        return new Projets(projet_id, nomProjet, margeBeneficiaire, coutTotal, etatProjet, clientId);
    }
}
