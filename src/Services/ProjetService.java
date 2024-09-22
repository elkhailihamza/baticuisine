package Services;

import Models.Projets;
import Repositories.GenericRepository;
import Repositories.ProjetRepository;

import java.util.List;

public class ProjetService {
    private final ProjetRepository projetRepository;

    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public Projets findById(long id) {
        return this.projetRepository.findById(id);
    }

    public List<Projets> fetchAll() {
        return this.projetRepository.fetchAll();
    }

    public void save(Projets entity) {
        this.projetRepository.save(entity);
    }

    public void update(Projets entity) {
        this.projetRepository.update(entity);
    }

    public void delete(Projets entity) {
        this.projetRepository.delete(entity);
    }
}
