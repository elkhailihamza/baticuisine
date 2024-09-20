package Core;

import Models.Clients;
import Repositories.ClientRepositoryImpl;
import Repositories.GenericRepository;
import Services.ClientService;

import java.sql.Connection;

public class Repository {
    private final ClientService ClientService;
    private Repository () {
        Connection connectionInstance = DB_Connection.getConnection();
        GenericRepository<Clients, Long> ClientRepositoryImpl = new ClientRepositoryImpl(connectionInstance);
        this.ClientService = new ClientService(ClientRepositoryImpl);
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
