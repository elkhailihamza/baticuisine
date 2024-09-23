package Repositories;

import java.util.List;

public interface GenericRepository<T, ID> {
    T findById(ID id);
    List<T> fetchAll();
    void save(T entity);
    T saveAndReturn(T entity);
    void update(T entity);
    T updateAndReturn(T entity);
    void delete(T entity);
}
