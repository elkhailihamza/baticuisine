package Views.MaterialView;

import Tools.GetValue;

public class GetMaterialDetailsView {
    public static double getMaterialCoutUnitaire() {
        return GetValue.doubleValue(new String[]{"Entrez le coût unitaire de ce matériau (€/m²) : "});
    }

    public static double getMaterialQuantite() {
        return GetValue.doubleValue(new String[]{"Entrez la quantité de ce matériau (en m²) : "});
    }

    public static double getCoutTransport() {
        return GetValue.doubleValue(new String[]{"Entrez le coût de transport de ce matériau (€) : "});
    }

    public static double getCoefficientQualite() {
        return GetValue.doubleValue(new String[]{"Entrez le coefficient de qualité du matériau (1.0 = standard, > 1.0 = haute qualité) : "});
    }
}
