package Repositories;

import Models.Clients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ClientRepository extends GenericRepository<Clients, Long> {
    Clients fetchByNom(String nom);

    default void assignClientToStmt(PreparedStatement stmt, Clients entity) throws SQLException {
        stmt.setString(1, entity.getNom());
        stmt.setString(2, entity.getAdresse());
        stmt.setString(3, entity.getTelephone());
        stmt.setBoolean(4, entity.getEstProfessionnel());
    }

    default Clients assignValuesToClients(ResultSet rs) throws SQLException {
        long clientId = rs.getLong("client_id");
        String clientNom = rs.getString("nom");
        String clientAdresse = rs.getString("adresse");
        String clientTelephone = rs.getString("telephone");
        boolean clientEstProfessionnel = rs.getBoolean("estprofessionnel");
        return new Clients(clientId, clientNom, clientAdresse, clientTelephone, clientEstProfessionnel);
    }
}
