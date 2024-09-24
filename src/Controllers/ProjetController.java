package Controllers;

import Enums.Etat;
import Models.*;
import Services.ComponentService;
import Services.LaborService;
import Services.MaterialService;
import Services.ProjetService;
import Tools.TextStyles;
import Views.ComponentView.GetComponentDetailsView;
import Views.ProjetView.GetProjetDetailsView;
import Views.ProjetView.ProjetView;

import java.util.*;
import java.util.stream.Collectors;

public class ProjetController extends Controller {
    private final ClientController clientController = new ClientController();
    private final MaterialController materialController = new MaterialController();
    private final LaborController laborController = new LaborController();
    private final QuoteController quoteController = new QuoteController();

    private final ProjetService projetService;
    private final ComponentService componentService;
    private final MaterialService materialService;
    private final LaborService laborService;

    public ProjetController() {
        super();
        this.projetService = repository.getProjetService();
        this.componentService = repository.getComponentService();
        this.materialService = repository.getMaterialService();
        this.laborService = repository.getLaborService();
    }

    public void createNewProjet() {
        Clients client = clientController.selectClient();
        if (!Objects.isNull(client)) {
            Projets projet = new Projets(1);

            List<Materials> materials;
            List<Labor> labors;
            List<Components> components = new ArrayList<>();

            double tauxTVA;
            double margeBeneficiaire = 0;

            projet.setClientId(client.getClient_id());
            projet.setNomProjet(ProjetView.createNewProject());

            materials = materialController.gatherMaterialObjs();
            labors = laborController.gatherLaborObjs();

            if (GetComponentDetailsView.getTVAConfirmation())
                tauxTVA = GetComponentDetailsView.getTVA();
            else {
                tauxTVA = 0;
            }

            if (GetComponentDetailsView.getMargeBeneficiaireConfirmation())
                margeBeneficiaire = GetComponentDetailsView.getMargeBeneficiaire();

            materials.forEach(m -> m.setTauxTVA(tauxTVA));
            labors.forEach(l -> l.setTauxTVA(tauxTVA));
            components.addAll(materials);
            components.addAll(labors);

            this.calcTotalPrice(projet, materials, labors, client, tauxTVA, margeBeneficiaire);

            Quotes quote = quoteController.createNewQuote(projet);

            projet.setEtatProjet(Etat.ENCOURS);
            Projets finalProjet = this.projetService.saveAndReturn(projet);

            quote.setProjectId(finalProjet.getProjet_id());
            quoteController.saveQuote(quote);

            double finalTauxTVA = tauxTVA;
            components.forEach(c -> {
                c.setTauxTVA(finalTauxTVA);
                c.setProjectId(finalProjet.getProjet_id());
                this.componentService.save(c);
            });
            ProjetView.saveSuccessful();
        } else {
            System.out.println("Project aborted!");
        }
    }

    public void calcTotalPrice(Projets projet, List<Materials> materialList, List<Labor> laborList, Clients client, double tauxTVA, double margeBenPourcentage) {
        HashMap<Materials, Double> materials = materialList.stream().collect(Collectors.toMap(k -> k, _ -> 0.0, (existing, _) -> existing, HashMap::new));
        HashMap<Labor, Double> labor = laborList.stream().collect(Collectors.toMap(l -> l, _ -> 0.0, (existing, _) -> existing, HashMap::new));
        updateCosts(materials, labor);

        double totalCostMat = this.calculateTotalMaterialCost(materials);
        double priceMatTVA = this.calculateTotalMaterialCostWithTVA(materials);

        double totalCostLab = this.calculateTotalLaborCost(labor);
        double priceLabTVA = this.calculateTotalLaborCostWithTVA(labor);

        double totalPriceNoMarge = priceMatTVA + priceLabTVA;

        projet.setMargeBeneficiaire(this.projetService.calcMargeBeneficiaire(totalPriceNoMarge, margeBenPourcentage));
        double coutTotal = totalPriceNoMarge + projet.getMargeBeneficiaire();
        projet.setCoutTotal(coutTotal);

        ProjetView.totalPriceResult(projet, materials, labor, client, tauxTVA, margeBenPourcentage, totalPriceNoMarge, totalCostMat, priceMatTVA, totalCostLab, priceLabTVA);
    }


    private void updateCosts(HashMap<Materials, Double> materials, HashMap<Labor, Double> labor) {
        materials.replaceAll((k, _) -> this.materialService.calcUnitCost(k));
        labor.replaceAll((k, _) -> this.laborService.calcWorkCost(k));
    }

    private double calculateTotalMaterialCost(HashMap<Materials, Double> materials) {
        return this.materialService.calcListCost(new ArrayList<>(materials.keySet()));
    }

    private double calculateTotalLaborCost(HashMap<Labor, Double> labor) {
        return this.laborService.calcListWorkCost(new ArrayList<>(labor.keySet()));
    }

    private double calculateTotalMaterialCostWithTVA(HashMap<Materials, Double> materials) {
        return this.materialService.calcListCostWithTVA(new ArrayList<>(materials.keySet()));
    }

    private double calculateTotalLaborCostWithTVA(HashMap<Labor, Double> labor) {
        return this.laborService.calcListCostWithTVA(new ArrayList<>(labor.keySet()));
    }

    public void displayProjets() {
        List<Projets> projets = this.projetService.fetchAll();
        if (!Objects.equals(projets, null))
            projets.forEach(ProjetView::displayProjet);
    }

    public void showProjetById() {
        long projetId = GetProjetDetailsView.getProjetId();
        Projets projet = this.projetService.findById(projetId);
        if (!Objects.equals(projet, null)) {
            ProjetView.displayProjetPrice(projet);
            return;
        }
        ProjetView.projetNotFound(projetId);
    }
}
