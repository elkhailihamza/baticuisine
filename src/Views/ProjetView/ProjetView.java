package Views.ProjetView;

import Views.View;

public class ProjetView extends View {
    public static String createNewProject() {
        header("--- Création d'un Nouveau Projet ---");
        return GetProjetDetailsView.getProjetName();
    }
}
