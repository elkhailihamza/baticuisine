package Controllers;

import Models.Clients;
import Models.Labor;
import Models.Materials;
import Models.Projets;
import Services.MaterialService;
import Views.ProjetView.GetProjetDetailsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProjetController extends Controller{
    private final ClientController clientController = new ClientController();
    private final ProjetController projetController = new ProjetController();
    private final ComponentController componentController = new ComponentController();
    private final MaterialController materialController = new MaterialController();
    private final LaborController laborController = new LaborController();
    private final QuoteController quoteController = new QuoteController();

    private final MaterialService materialService;

    public ProjetController() {
        super();
        this.materialService = repository.getMaterialService();
    }

    public String getNewProjectName() {
        return GetProjetDetailsView.getProjetName();
    }

    public void createNewProjet() {
        Clients client = clientController.selectClient();
        Projets projet = new Projets(1);
        if (!Objects.isNull(client)) {
            HashMap<String, Materials> materials;
            HashMap<String, Labor> labors;

            projet.setClientId(client.getClient_id());
            projet.setNomProjet(projetController.getNewProjectName());
            materials = materialController.gatherMaterialObjs();
            labors = laborController.

        } else {
            System.out.println("Project aborted!");
        }
    }
}
