package Services;

import Models.Labor;
import Repositories.GenericRepository;
import Repositories.LaborRepository;

import java.util.List;

public class LaborService {
    private final LaborRepository laborRepository;

    public LaborService(LaborRepository laborRepository) {
        this.laborRepository = laborRepository;
    }

    public Labor findById(long id) {
        return this.laborRepository.findById(id);
    }

    public List<Labor> fetchAll() {
        return this.laborRepository.fetchAll();
    }

    public void save(Labor entity) {
        this.laborRepository.save(entity);
    }

    public void update(Labor entity) {
        this.laborRepository.update(entity);
    }

    public void delete(Labor entity) {
        this.laborRepository.delete(entity);
    }
}
