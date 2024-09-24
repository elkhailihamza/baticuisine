package Views;

import Tools.GetValue;
import Tools.TextStyles;

public class MainMenu {
    public static int displayMenu() {
        TextStyles.header("=== Menu Principal ===");
        String[] opts = {"Créer un nouveau projet", "Afficher les projets existants", "Calculer le coût d'un projet", "Voir toutes les devis", "Quitter"};
        TextStyles.options(opts);
        TextStyles.footer("Choisissez une option :");

        return GetValue.validNum(opts.length);
    }

    public static boolean goBack(int value) {
        TextStyles.text("0). Go Back");
        return value == 0;
    }

    public static boolean goBack(long value) {
        TextStyles.text("0). Go Back");
        return value == 0;
    }
}
