package Views.ClientView;

import Views.View;

public class GetClientDetailsView extends View {
    public static String getClientName() {
        return getStringInput(new String[]{"Entrez le nom du client :"});
    }

    public static String getClientAdresse() {
        return getStringInput(new String[]{"Entrez l'adresse du client :"});
    }

    public static String getClientTelephone() {
        return getStringInput(new String[]{"Entrez le tel du client :"});
    }

    public static boolean getEstProfessionnel() {
        return getBooleanValue(new String[]{"Entrez le tel du client :"});
    }
}
