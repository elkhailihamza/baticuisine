package Repositories;

import Models.Quotes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuoteRepositoryImpl implements QuoteRepository {
    private static Connection connectionInstance;

    public QuoteRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public Quotes findById(Long aLong) {
        Quotes quote = null;
        String sql = "SELECT * FROM quotes WHERE quote_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, aLong);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    quote = this.assignValuesToQuotes(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Quotes Find by id err: " + e);
        }
        return quote;
    }

    @Override
    public List<Quotes> fetchAll() {
        List<Quotes> quotes = new ArrayList<>();
        String sql = "SELECT * FROM quotes;";
        try (Statement stmt = connectionInstance.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Quotes quote = this.assignValuesToQuotes(rs);
                quotes.add(quote);
            }
        } catch (SQLException e) {
            System.out.println("Quotes Fetch all err: " + e);
        }
        return quotes;
    }

    @Override
    public void save(Quotes entity) {
        String sql = "INSERT INTO quotes (montantEstime, dateEmission, dateValidate, accepte, projetid) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignQuoteToStmt(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Quotes add err: " + e);
        }
    }

    @Override
    public Quotes saveAndReturn(Quotes entity) {
        Quotes quote = null;
        String sql = "INSERT INTO quotes (montantEstime, dateEmission, dateValidate, accepte, projetid) VALUES (?, ?, ?, ?, ?) RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignQuoteToStmt(stmt, entity);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                quote = this.assignValuesToQuotes(rs);
        } catch (SQLException e) {
            System.out.println("Quotes add err: " + e);
        }
    }

    @Override
    public void update(Quotes entity) {
        String sql = "UPDATE quotes SET montantEstime = ?, dateEmission = ?, dateValidate = ?, accepte = ?, projetid = ? WHERE quote_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignQuoteToStmt(stmt, entity);
            stmt.setLong(6, entity.getQuote_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Quotes update err: " + e);
        }
    }

    @Override
    public Quotes updateAndReturn(Quotes entity) {
        Quotes quote = null;
        String sql = "UPDATE quotes SET montantEstime = ?, dateEmission = ?, dateValidate = ?, accepte = ?, projetid = ? WHERE quote_id = ? RETURNING *;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            this.assignQuoteToStmt(stmt, entity);
            stmt.setLong(6, entity.getQuote_id());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                quote = this.assignValuesToQuotes(rs);
        } catch (SQLException e) {
            System.out.println("Quotes update err: " + e);
        }
        return quote;
    }

    @Override
    public void delete(Quotes entity) {
        String sql = "DELETE FROM quotes WHERE quote_id = ?;";
        try (PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            stmt.setLong(1, entity.getQuote_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Quotes delete err: " + e);
        }
    }
}
