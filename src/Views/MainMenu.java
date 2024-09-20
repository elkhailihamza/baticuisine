package Views;

public class MainMenu extends View {
    public int displayMenu() {
        header("=== Menu Principal ===");
        String[] options = {"Créer un nouveau projet", "Afficher les projets existants", "Calculer le coût d'un projet", "Quitter"};
        options(options);
        footer("Choisissez une option :");
        return 0;
    }
}
