package Views.ClientView;

import Models.Clients;
import Views.View;

public class ClientView extends View {
    public static int displayMenu() {
        header("--- Recherche de client ---");
        header("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        String[] options = {"Chercher un client existant", "Ajouter un nouveau client"};
        options(options);
        footer("Choisissez une option :");

        return returnValidNum(options);
    }

    private static void displayClientShortInfo(Clients client) {
        success("Client trouvé !");
        header("Nom: "+client.getNom());
        header("Adresse: "+client.getAdresse());
        header("Numéro de téléphone : "+client.getTelephone());
    }

    public static boolean clientFound(Clients client) {
        displayClientShortInfo(client);
        footer("Souhaitez-vous continuer avec ce client ? (y/n) :");
        return checkIfInputIsY();
    }

    public static Clients clientNotFound() {
        error("Client not found!");
        return null;
    }
}
