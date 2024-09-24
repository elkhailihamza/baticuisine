package Views.MaterialView;

import Models.Components;
import Models.Materials;
import Tools.GetValue;
import Tools.TextStyles;

public class MaterialView {
    public static void displayMenu() {
        TextStyles.header("Ajout des matériaux");
    }

    public static boolean askToContinue() {
        return GetValue.yOrNValue(new String[]{"Voulez-vous ajouter un autre matériau ? (y/n) : "});
    }

    public static void displaySize(int size) {
        TextStyles.text("Materiel n°: "+size);
    }

    public static void saveSuccessful() {
        TextStyles.text("Matériau ajouté avec succès !");
    }

    public static void displayMaterialComponent(Materials m, double unitPrice) {
        TextStyles.text("- "+m.getNom()+" : "+"(quantité : "+m.getQuantite()+" m², coût unitaire : "+m.getCoutUnitaire()+" €/m², qualité : "+m.getCoefficientQualite()+", transport : "+m.getCoutTransport()+" €)");
    }
}
