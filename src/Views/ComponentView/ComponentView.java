package Views.ComponentView;

import Views.View;

public class ComponentView extends View {
    public static boolean getTVAConfirmation() {
        return getYValue(new String[]{"Souhaitez-vous appliquer une TVA au projet ? (y/n) :"});
    }

    public static double getTVA() {
        return getDoubleValue(new String[]{"Entrez le pourcentage de TVA (%) :"});
    }

    public static boolean getMargeBeneficiaireConfirmation() {
        return getYValue(new String[]{"Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) :"});
    }

    public static double getMargeBeneficiaire() {
        return getDoubleValue(new String[]{"Entrez le pourcentage de marge bénéficiaire (%) :"});
    }

}
