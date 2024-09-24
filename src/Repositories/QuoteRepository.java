package Repositories;

import Models.Quotes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface QuoteRepository extends GenericRepository<Quotes, Long> {
    default void assignQuoteToStmt(PreparedStatement stmt, Quotes entity) throws SQLException {
        stmt.setDouble(1, entity.getMontantEstime());
        stmt.setDate(2, Date.valueOf(entity.getDateEmission()));
        stmt.setDate(3, Date.valueOf(entity.getDateValidate()));
        stmt.setBoolean(4, entity.isAccepte());
        stmt.setLong(5, entity.getProjectId());
    }

    default Quotes assignValuesToQuotes(ResultSet rs) throws SQLException {
        long quoteId = rs.getLong("quote_id");
        double montantEstime = rs.getDouble("montantEstime");
        LocalDate dateEmission = rs.getDate("dateEmission").toLocalDate();
        LocalDate dateValidate = rs.getDate("dateValidate").toLocalDate();
        boolean accepte = rs.getBoolean("accepte");
        long projectId = rs.getLong("projectid");
        return new Quotes(quoteId, montantEstime, dateEmission, dateValidate, accepte, projectId);
    }
}
