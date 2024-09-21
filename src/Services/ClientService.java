package Services;

import Models.Clients;
import Repositories.GenericRepository;

import java.util.List;

public class ClientService {
    private final GenericRepository<Clients, Long> ClientRepository;
    public ClientService(GenericRepository<Clients, Long> ClientRepository) {
        this.ClientRepository = ClientRepository;
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

    public void update(Clients entity) {
        this.ClientRepository.update(entity);
    }

    public void delete(Clients entity) {
        this.ClientRepository.delete(entity);
    }

    public boolean isProfessionnel(long id) {
        return this.findById(id).getEstProfessionnel();
    }
}
