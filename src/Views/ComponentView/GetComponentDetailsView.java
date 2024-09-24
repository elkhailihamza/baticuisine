package Views.ComponentView;

import Tools.GetValue;

public class GetComponentDetailsView {
    public static String getComponentName() {
        return GetValue.stringValue(new String[]{"Entrez le nom du composent :"});
    }

    public static boolean getTVAConfirmation() {
        return GetValue.yOrNValue(new String[]{"Souhaitez-vous appliquer une TVA au projet ? (y/n) :"});
    }

    public static double getTVA() {
        return GetValue.doubleValue(new String[]{"Entrez le pourcentage de TVA (%) :"});
    }

    public static boolean getMargeBeneficiaireConfirmation() {
        return GetValue.yOrNValue(new String[]{"Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) :"});
    }

    public static double getMargeBeneficiaire() {
        return GetValue.doubleValue(new String[]{"Entrez le pourcentage de marge bénéficiaire (%) :"});
    }

}
