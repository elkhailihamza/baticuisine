package Repositories;

import Models.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements GenericRepository<Clients, Long>, ClientRepository {
    private static Connection connectionInstance;

    public ClientRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Clients findById(Long aLong) {
        Clients user = null;
        String sql = "SELECT * FROM clients WHERE clients.client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    user = this.assignValuesToClients(rs);
            }
        } catch (SQLException e) {
            System.out.println("Clients Find by id: " + e);
        }
        return user;
    }

    @Override
    public List<Clients> fetchAll() {
        List<Clients> Clients = new ArrayList<>(List.of());
        String sql = "SELECT * FROM Clients;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Clients user = this.assignValuesToClients(rs);
                Clients.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Clients Fetch all err: " + e);
        }
        return Clients;
    }

    @Override
    public void save(Clients entity) {
        String sql = "INSERT INTO clients (nom, adresse, telephone, estprofessionnel) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setString(1, entity.getNom());
            stmt.setString(2, entity.getAdresse());
            stmt.setString(3, entity.getTelephone());
            stmt.setBoolean(4, entity.getEstProfessionnel());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients add err: "+e);
        }
    }

    @Override
    public void update(Clients entity) {
        String sql = "UPDATE clients SET nom = ?, adresse = ?, telephone = ?, estprofessionnel = ? WHERE clients.client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setString(1, entity.getNom());
            stmt.setString(2, entity.getAdresse());
            stmt.setString(3, entity.getTelephone());
            stmt.setBoolean(4, entity.getEstProfessionnel());
            stmt.setLong(5, entity.getClient_id());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients update err: "+e);
        }
    }

    @Override
    public void delete(Clients entity) {
        String sql = "DELETE FROM clients WHERE clients.client_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getClient_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Clients delete err: "+e);
        }
    }

    private Clients assignValuesToClients(ResultSet rs) throws SQLException {
        long clientId = rs.getLong("client_id");
        String clientNom = rs.getString("nom");
        String clientAdresse = rs.getString("adresse");
        String clientTelephone = rs.getString("telephone");
        boolean clientEstProfessionnel = rs.getBoolean("estprofessionnel");
        return new Clients(clientId, clientNom, clientAdresse, clientTelephone, clientEstProfessionnel);
    }

}
