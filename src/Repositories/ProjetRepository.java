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
        stmt.setString(4, entity.getEtatProjet().getDbValue());
        stmt.setLong(5, entity.getClientId());
    }

    default Projets assignValuesToProjets(ResultSet rs) throws SQLException {
        long projet_id = rs.getLong("projet_id");
        String nomProjet = rs.getString("nomprojet");
        double margeBeneficiaire = rs.getDouble("margebeneficiaire");
        double coutTotal = rs.getDouble("couttotal");
        Etat etatProjet = Etat.fromDbValue(rs.getString("etatprojet"));
        long clientId = rs.getLong("clientid");
        return new Projets(projet_id, nomProjet, margeBeneficiaire, coutTotal, etatProjet, clientId);
    }
}
