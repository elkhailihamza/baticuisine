package Core;

import Models.Clients;
import Models.Components;
import Models.Materials;
import Repositories.ClientRepositoryImpl;
import Repositories.ComponentRepositoryImpl;
import Repositories.GenericRepository;
import Repositories.MaterialRepositoryImpl;
import Services.ClientService;

import java.sql.Connection;

public class Repository {
    private final ClientService ClientService;
    private Repository () {
        Connection connectionInstance = DB_Connection.getConnection();

        GenericRepository<Clients, Long> ClientRepository = new ClientRepositoryImpl(connectionInstance);
        GenericRepository<Components, Long> ComponentRepository = new ComponentRepositoryImpl(connectionInstance);
        GenericRepository<Materials, Long> MaterialRepository = new MaterialRepositoryImpl(connectionInstance);

        this.ClientService = new ClientService(ClientRepository);
    }

    private static class repositoryHelper {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository repository() {
        return repositoryHelper.INSTANCE;
    }

    public ClientService getClientService() {
        return this.ClientService;
    }
}
