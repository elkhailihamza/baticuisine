package Views.MaterialView;

import Views.View;

public class GetMaterialDetailsView extends View {
    public static double getMaterialCoutUnitaire() {
        return getDoubleValue(new String[]{"Entrez le cout unitaire"});
    }

    public static double getMaterialQuantite() {
        return getDoubleValue(new String[]{"Entrez la quantite :"});
    }

    public static double getCoutTransport() {
        return getDoubleValue(new String[]{"Entrez le cout transport :"});
    }

    public static double getCoefficientQualite() {
        return getDoubleValue(new String[]{"Entrez le coefficient qualite :"});
    }
}
