package Services;

import Models.Labor;
import Models.Materials;
import Repositories.ComponentRepository;
import Repositories.LaborRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public double calcWorkCost(Labor entity) {
        return entity.getHourlyRate() * entity.getHoursWorked() * entity.getWorkerProductivity();
    }

    public double calcWorkCostWithTVA(Labor entity, double TVA) {
        if (TVA < 0) {
            throw new IllegalArgumentException("TVA cannot be negative.");
        }
        double unitPrice = this.calcWorkCost(entity);
        double tax = TVA / 100;
        return (unitPrice * tax) + unitPrice;
    }

    public double calcListWorkCost(List<Labor> labor) {
        return labor.stream()
                .mapToDouble(this::calcWorkCost)
                .sum();
    }

    public double calcListCostWithTVA(List<Labor> labor) {
        return labor.stream()
                .mapToDouble(l -> this.calcWorkCostWithTVA(l, l.getTauxTVA()))
                .sum();
    }
}
