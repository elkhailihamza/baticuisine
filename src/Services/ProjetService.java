package Services;

import Models.Projets;
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

    public Projets saveAndReturn(Projets entity) {
        return this.projetRepository.saveAndReturn(entity);
    }

    public void update(Projets entity) {
        this.projetRepository.update(entity);
    }

    public void delete(Projets entity) {
        this.projetRepository.delete(entity);
    }

    public double calcMargeBeneficiaire(double totalPriceNoMarge, double margeBenPourcentage) {
        if (margeBenPourcentage <= 0) {
            return totalPriceNoMarge;
        }
        double pourcentage = margeBenPourcentage / 100;
        return Math.round(totalPriceNoMarge * pourcentage);
    }
}
