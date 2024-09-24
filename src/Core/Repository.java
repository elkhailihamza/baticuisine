package Core;

import Repositories.*;
import Repositories.Implementations.*;
import Services.*;

import java.sql.Connection;

public class Repository {
    private final ClientService ClientService;
    private final ProjetService ProjetService;
    private final QuoteService QuoteService;
    private final ComponentService ComponentService;
    private final MaterialService MaterialService;
    private final LaborService LaborService;
    private Repository () {
        Connection connectionInstance = DB_Connection.getConnection();

        ClientRepository ClientRepository = new ClientRepositoryImpl(connectionInstance);
        ProjetRepository ProjetRepository = new ProjetRepositoryImpl(connectionInstance);
        QuoteRepository QuoteRepository = new QuoteRepositoryImpl(connectionInstance);
        ComponentRepository ComponentRepository = new ComponentRepositoryImpl(connectionInstance);
        MaterialRepository MaterialRepository = new MaterialRepositoryImpl(connectionInstance);
        LaborRepository LaborRepository = new LaborRepositoryImpl(connectionInstance);

        this.ClientService = new ClientService(ClientRepository);
        this.ProjetService = new ProjetService(ProjetRepository);
        this.QuoteService = new QuoteService(QuoteRepository);
        this.ComponentService = new ComponentService(ComponentRepository);
        this.MaterialService = new MaterialService(MaterialRepository);
        this.LaborService = new LaborService(LaborRepository);
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

    public Services.ProjetService getProjetService() {
        return ProjetService;
    }

    public Services.QuoteService getQuoteService() {
        return QuoteService;
    }

    public Services.ComponentService getComponentService() {
        return ComponentService;
    }

    public Services.MaterialService getMaterialService() {
        return MaterialService;
    }

    public Services.LaborService getLaborService() {
        return LaborService;
    }
}
