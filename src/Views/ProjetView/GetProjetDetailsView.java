package Views.ProjetView;

import Tools.GetValue;

public class GetProjetDetailsView {
    public static long getProjetId() {
        return GetValue.longValue(new String[]{"Entrez l'id du projet :"});
    }

    public static String getProjetName() {
        return GetValue.stringValue(new String[]{"Entrez le nom du projet :"});
    }

    public static double getProjetMargeBeneficiaire() {
        return GetValue.doubleValue(new String[]{"Entrez la marge beneficiaire :"});
    }

    public static double getProjetCoutTotal() {
        return GetValue.doubleValue(new String[]{"Entrez le cout total :"});
    }

    public static boolean getEtatProjet() {
        return GetValue.booleanValue(new String[]{"Changer l'etat du projet :"});
    }
}
