package Services;

import Models.Clients;
import Repositories.ClientRepository;

import java.util.List;

public class ClientService {
    private final ClientRepository ClientRepository;
    public ClientService(ClientRepository ClientRepository) {
        this.ClientRepository = ClientRepository;
    }

    public Clients fetchByNom(String nom) {
        return this.ClientRepository.fetchByNom(nom);
    }

    public Clients findById(long id) {
        return this.ClientRepository.findById(id);
    }

    public List<Clients> fetchAll() {
        return this.ClientRepository.fetchAll();
    }

    public void save(Clients entity) {
        this.ClientRepository.save(entity);
    }

    public Clients saveAndReturn(Clients entity) {
        return this.ClientRepository.saveAndReturn(entity);
    }

    public void update(Clients entity) {
        this.ClientRepository.update(entity);
    }

    public Clients updateAndReturn(Clients entity) {
        return this.ClientRepository.updateAndReturn(entity);
    }

    public void delete(Clients entity) {
        this.ClientRepository.delete(entity);
    }

    public double useDiscount(double totalPrice, double discount) {
        if (discount <= 0)
            return totalPrice;
        double pourcentage = discount / 100;
        return Math.round(totalPrice * pourcentage);
    }
}
