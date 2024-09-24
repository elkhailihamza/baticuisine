package Services;

import Models.Materials;
import Repositories.MaterialRepository;

import java.util.List;

public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
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

    public double calcUnitCost(Materials entity) {
        return Math.round((entity.getQuantite() * entity.getCoutUnitaire() * entity.getCoefficientQualite()) + entity.getCoutTransport());
    }

    public double calcUnitCostTVA(Materials entity, double TVA) {
        if (TVA < 0) {
            throw new IllegalArgumentException("TVA cannot be negative.");
        }
        double unitPrice = this.calcUnitCost(entity);
        double tax = TVA / 100;
        return Math.round((unitPrice * tax) + unitPrice);
    }

    public double calcListCost(List<Materials> materials) {
        return materials.stream()
                .mapToDouble(this::calcUnitCost)
                .sum();
    }


    public double calcListCostWithTVA(List<Materials> materials) {
        return materials.stream()
                .mapToDouble(m -> this.calcUnitCostTVA(m, m.getTauxTVA()))
                .sum();
    }
}
