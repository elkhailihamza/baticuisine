package Controllers;

import Models.Components;
import Models.Materials;
import Models.Projets;
import Services.ComponentService;
import Views.ComponentView.GetComponentDetailsView;
import Views.MaterialView.GetMaterialDetailsView;
import Views.MaterialView.MaterialView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaterialController extends Controller {
    private final ComponentService componentService;

    public MaterialController() {
        super();
        this.componentService = repository.getComponentService();
    }

    public List<Materials> gatherMaterialObjs() {
        boolean continueCreating = true;
        List<Materials> materials = new ArrayList<>();
        while (continueCreating) {
            materials.forEach(material -> {
                material = createNewMaterialObj();
            });
            continueCreating = MaterialView.askToContinue();
        }
        return materials;
    }

    public Materials createNewMaterialObj() {
        String nom = GetComponentDetailsView.getComponentName();
        double quantite = GetMaterialDetailsView.getMaterialQuantite();
        double coutUnitaire = GetMaterialDetailsView.getCoutTransport();
        double coutTransport = GetMaterialDetailsView.getCoutTransport();
        double coefficientQualite = GetMaterialDetailsView.getCoefficientQualite();

        return new Materials(1, nom, "Materiel", 1, quantite, coutUnitaire, coutTransport, coefficientQualite, 1);
    }
}
