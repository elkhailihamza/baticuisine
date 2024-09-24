package Views.ClientView;

import Models.Clients;
import Tools.GetValue;
import Tools.TextStyles;

public class ClientView {
    public static int displayMenu() {
        TextStyles.header("--- Recherche de client ---");
        TextStyles.header("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        String[] opts = {"Chercher un client existant", "Ajouter un nouveau client"};
        TextStyles.options(opts);
        TextStyles.footer("Choisissez une option :");

        return GetValue.validNum(opts.length);
    }

    private static void displayClientShortInfo(Clients client) {
        TextStyles.success("Client trouvé !");
        TextStyles.header("Nom: "+client.getNom());
        TextStyles.header("Adresse: "+client.getAdresse());
        TextStyles.header("Numéro de téléphone : "+client.getTelephone());
    }

    public static boolean clientFound(Clients client) {
        displayClientShortInfo(client);
        return GetValue.yOrNValue(new String[]{"Souhaitez-vous continuer avec ce client ? (y/n) :"});
    }

    public static Clients clientNotFound() {
        TextStyles.error("Client not found!");
        return null;
    }
}
