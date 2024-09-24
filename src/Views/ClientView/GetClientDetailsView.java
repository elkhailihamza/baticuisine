package Views.ClientView;

import Tools.GetValue;

public class GetClientDetailsView {
    public static String getClientName() {
        return GetValue.stringValue(new String[]{"Entrez le nom du client :"});
    }

    public static String getClientAdresse() {
        return GetValue.stringValue(new String[]{"Entrez l'adresse du client :"});
    }

    public static String getClientTelephone() {
        return GetValue.stringValue(new String[]{"Entrez le tel du client :"});
    }

    public static boolean getEstProfessionnel() {
        return GetValue.yOrNValue(new String[]{"Est ce que ce client est professionnel? (y/n) :"});
    }
}
