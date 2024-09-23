package Views.ProjetView;

import Views.View;

public class GetProjetDetailsView extends View {
    public static String getProjetName() {
        return getStringInput(new String[]{"Entrez le nom du projet :"});
    }

    public static double getProjetMargeBeneficiaire() {
        return getDoubleValue(new String[]{"Entrez la marge beneficiaire :"});
    }

    public static double getProjetCoutTotal() {
        return getDoubleValue(new String[]{"Entrez le cout total :"});
    }

    public static boolean getEtatProjet() {
        return getBooleanValue(new String[]{"Changer l'etat du projet :"});
    }
}
