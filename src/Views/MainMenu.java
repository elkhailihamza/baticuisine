package Views;

import Tools.GetValue;
import Tools.TextStyles;

public class MainMenu {
    public static int displayMenu() {
        TextStyles.header("=== Menu Principal ===");
        String[] opts = {"Créer un nouveau projet", "Afficher les projets existants", "Calculer le coût d'un projet", "Quitter"};
        TextStyles.options(opts);
        TextStyles.footer("Choisissez une option :");

        return GetValue.validNum(opts.length);
    }
}
