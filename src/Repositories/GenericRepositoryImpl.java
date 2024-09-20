package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {
    private static Connection connectionInstance;
    public GenericRepositoryImpl(Connection db_connection) {
        connectionInstance = db_connection;
    }

    @Override
    public T findById(ID id) {
        T entity = null;
        String sql = "SELECT * FROM <table_name> WHERE id = ?";
        try(PreparedStatement stmt = connectionInstance.prepareStatement(sql)) {
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    entity = mapResultSetToEntity(rs);
            }
        } catch(SQLException e) {
            System.out.println("FindByID err: "+e);
        }
        return entity;
    }

    @Override
    public List<T> fetchAll() {
        return List.of();
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
