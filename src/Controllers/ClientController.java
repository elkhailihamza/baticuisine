package Controllers;

import Models.Clients;
import Services.ClientService;
import Views.ClientView.ClientView;
import Views.ClientView.GetClientDetailsView;

import java.util.Objects;

public class ClientController extends Controller {
    private final ClientService clientService;

    public ClientController() {
        super();
        this.clientService = repository.getClientService();
    }

    public Clients selectClient() {
        boolean selectThisClient = true;
        Clients client = null;
        while (Objects.isNull(client)) {
            int num = ClientView.displayMenu();
            client = switch (num) {
                case 1 -> this.selectClientByName();
                case 2 -> this.returnNewlyCreatedClient();
                default -> null;
            };
        }
        return client;
    }

    private Clients selectClientByName() {
        System.out.println("--- Recherche de client existant ---");
        String name = GetClientDetailsView.getClientName();
        Clients client = this.clientService.fetchByNom(name);
        return checkIfClientIsFound(client);
    }

    private Clients returnNewlyCreatedClient() {
        String nom = GetClientDetailsView.getClientName();
        String adresse = GetClientDetailsView.getClientAdresse();
        String tel = GetClientDetailsView.getClientTelephone();
        boolean estProfessionnel = GetClientDetailsView.getEstProfessionnel();

        Clients client = new Clients(1, nom, adresse, tel, estProfessionnel);
        return checkIfClientIsFound(clientService.saveAndReturn(client));
    }

    private Clients checkIfClientIsFound(Clients client) {
        if (Objects.isNull(client))
            return ClientView.clientNotFound();

        if (ClientView.clientFound(client))
            return client;
        return null;
    }

}
