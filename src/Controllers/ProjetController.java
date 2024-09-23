package Controllers;

import Models.*;
import Services.ComponentService;
import Services.ProjetService;
import Views.ComponentView.ComponentView;
import Views.ProjetView.GetProjetDetailsView;
import Views.ProjetView.ProjetView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjetController extends Controller {
    private final ClientController clientController = new ClientController();
    private final ProjetController projetController = new ProjetController();
    private final MaterialController materialController = new MaterialController();
    private final LaborController laborController = new LaborController();
    private final QuoteController quoteController = new QuoteController();

    private final ProjetService projetService;
    private final ComponentService componentService;

    public ProjetController() {
        super();
        this.projetService = repository.getProjetService();
        this.componentService = repository.getComponentService();
    }

    public String getNewProjectName() {
        return GetProjetDetailsView.getProjetName();
    }

    public void createNewProjet() {
        Clients client = clientController.selectClient();
        if (!Objects.isNull(client)) {
            Projets projet = new Projets(1);

            List<Materials> materials;
            List<Labor> labors;
            List<Components> components = new ArrayList<>();

            double tauxTVA;
            double margeBeneficiaire = 1;

            projet.setClientId(client.getClient_id());
            projet.setNomProjet(projetController.getNewProjectName());

            materials = materialController.gatherMaterialObjs();
            labors = laborController.gatherLaborObjs();

            if (ComponentView.getTVAConfirmation())
                tauxTVA = ComponentView.getTVA();
            else
                tauxTVA = 1;

            if (ComponentView.getMargeBeneficiaireConfirmation())
                margeBeneficiaire = ComponentView.getMargeBeneficiaire();

            projet.setMargeBeneficiaire(margeBeneficiaire);

            components.addAll(materials);
            components.addAll(labors);

            quoteController.registerNewQuote(projet);

            this.projetService.saveAndReturn(projet);
            components.forEach(c -> {
                c.setTauxTVA(tauxTVA);
                this.componentService.save(c);
            });
            ProjetView.saveSuccessful();
        } else {
            System.out.println("Project aborted!");
        }
    }
}
