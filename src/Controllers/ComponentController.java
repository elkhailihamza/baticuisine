package Controllers;

import Models.Components;
import Views.ComponentView.GetComponentDetailsView;

public class ComponentController extends Controller{
    private final ProjetController ProjetController = new ProjetController();
    private final MaterialController materialController = new MaterialController();

    public ComponentController() {
        super();
    }

    public Components createNewComponent(String nom, String typeComponent, double tauxTVA, long projetId) {
        return new Components(1, nom, typeComponent, tauxTVA, projetId);
    }
}
