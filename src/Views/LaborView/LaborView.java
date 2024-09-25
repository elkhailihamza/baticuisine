package Views.LaborView;

import Models.Labor;
import Tools.GetValue;
import Tools.TextStyles;

public class LaborView {
    public static void displayMenu() {
        TextStyles.header("Ajout de la main-d'œuvre");
    }

    public static void displaySize(int size) {
        TextStyles.text("Labor n°: " + size);
    }

    public static boolean askToContinue() {
        return GetValue.yOrNValue(new String[]{"Voulez-vous ajouter un autre type de main-d'œuvre ? (y/n) : "});
    }

    public static void saveSuccessful() {
        TextStyles.text("Main-d'œuvre ajoutée avec succès !");
    }

    public static void displayLaborComponent(Labor l, double unitPrice) {
        TextStyles.text("- "+l.getNom()+"  € (taux horaire : "+l.getHourlyRate()+" €/h, heures travaillées : "+l.getHoursWorked()+" h, productivité : "+l.getWorkerProductivity()+")");
    }
}
