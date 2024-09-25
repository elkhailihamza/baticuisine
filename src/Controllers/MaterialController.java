package Controllers;

import Models.Materials;
import Services.ComponentService;
import Views.ComponentView.GetComponentDetailsView;
import Views.MaterialView.GetMaterialDetailsView;
import Views.MaterialView.MaterialView;

import java.util.ArrayList;
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
        Materials material;

        MaterialView.displayMenu();
        while (continueCreating) {
            MaterialView.displaySize(materials.size()+1);
            material = createNewMaterialObj();
            materials.add(material);
            MaterialView.saveSuccessful();
            continueCreating = MaterialView.askToContinue();
        }
        return materials;
    }

    public Materials createNewMaterialObj() {
        String nom = GetComponentDetailsView.getComponentName();
        double quantite = GetMaterialDetailsView.getMaterialQuantite();
        double coutUnitaire = GetMaterialDetailsView.getMaterialCoutUnitaire();
        double coutTransport = GetMaterialDetailsView.getCoutTransport();
        double coefficientQualite = GetMaterialDetailsView.getCoefficientQualite();

        return new Materials(1, nom, "Materiel", 1, quantite, coutUnitaire, coutTransport, coefficientQualite, 1);
    }
}

