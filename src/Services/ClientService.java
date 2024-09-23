package Services;

import Models.Clients;
import Repositories.ClientRepository;
import Repositories.GenericRepository;

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

    public boolean isProfessionnel(long id) {
        return this.findById(id).getEstProfessionnel();
    }
}
