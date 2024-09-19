package Repositories;

import java.util.List;

public class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {
    @Override
    public T findById() {
        return null;
    }

    @Override
    public T findById(ID id) {
        return null;
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
