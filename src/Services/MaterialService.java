package Services;

import Models.Materials;
import Repositories.GenericRepository;

import java.util.List;

public class MaterialService {
    private final GenericRepository<Materials, Long> materialRepository;

    public MaterialService(GenericRepository<Materials, Long> materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Materials findById(long id) {
        return this.materialRepository.findById(id);
    }

    public List<Materials> fetchAll() {
        return this.materialRepository.fetchAll();
    }

    public void save(Materials entity) {
        this.materialRepository.save(entity);
    }

    public void update(Materials entity) {
        this.materialRepository.update(entity);
    }

    public void delete(Materials entity) {
        this.materialRepository.delete(entity);
    }
}
