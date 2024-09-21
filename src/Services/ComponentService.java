package Services;

import Models.Components;
import Repositories.GenericRepository;

import java.util.List;

public class ComponentService {
    private final GenericRepository<Components, Long> componentRepository;

    public ComponentService(GenericRepository<Components, Long> componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Components findById(long id) {
        return this.componentRepository.findById(id);
    }

    public List<Components> fetchAll() {
        return this.componentRepository.fetchAll();
    }

    public void save(Components entity) {
        this.componentRepository.save(entity);
    }

    public void update(Components entity) {
        this.componentRepository.update(entity);
    }

    public void delete(Components entity) {
        this.componentRepository.delete(entity);
    }
}