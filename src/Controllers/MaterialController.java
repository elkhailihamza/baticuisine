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

    public HashMap<String, Materials> gatherMaterialObjs() {
        boolean continueCreating = true;
        HashMap<String, Materials> materials = new HashMap<>();
        while (continueCreating) {
            String nom = GetComponentDetailsView.getComponentName();
            materials.forEach((s, material) -> {
                s = nom;
                material = createNewMaterial();
            });
            continueCreating = MaterialView.askToContinue();
        }
        return materials;
    }

    public Materials createNewMaterialObj() {
        double quantite = GetMaterialDetailsView.getMaterialQuantite();
        double coutUnitaire = GetMaterialDetailsView.getCoutTransport();
        double coutTransport = GetMaterialDetailsView.getCoutTransport();
        double coefficientQualite = GetMaterialDetailsView.getCoefficientQualite();

        return new Materials(1, quantite, coutUnitaire, coutTransport, coefficientQualite);
    }
}
