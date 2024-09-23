package Views.ProjetView;

import Models.*;
import Views.View;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ProjetView extends View {
    public static String createNewProject() {
        header("--- Création d'un Nouveau Projet ---");
        return GetProjetDetailsView.getProjetName();
    }

    public static void calcTotalPrice(Projets projet, Clients client, List<Components> components) {
        AtomicReference<Double> priceAvantTVA = new AtomicReference<>(0.0);
        AtomicReference<Double> priceAvecTVA = new AtomicReference<>(0.0);

        header("Calcul du coût en cours...");
        header("--- Résultat du Calcul ---");
        header("Nom du projet :" + projet.getNomProjet());
        header("Client: " + client.getNom());
        header("Adresse du chantier :" + client.getAdresse());
        header("--- Détail des Coûts ---");
        header("1. Matériaux :");
        components.stream()
                .filter(c -> Objects.equals(c.getTypeComponant(), "Materiel"))
                .forEach(c -> {
                    if (c instanceof Materials m) {
                        displayMaterielDetails(m, calcUnitCost(m));
                        priceAvantTVA.updateAndGet(v -> (double) (v + calcUnitCost(m)));
                        priceAvecTVA.updateAndGet(v -> (double) (v + calcUnitCostWithTVA(m, m.getTauxTVA())));
                    }
                });
        header("**Coût total des matériaux avant TVA : " + priceAvantTVA + " €**");
        header("**Coût total des matériaux avec TVA (" + components.getFirst().getTauxTVA() + ") : " + priceAvecTVA + " €**");
        header("2. Main-d'œuvre : ");
        components.stream()
                .filter(c -> Objects.equals(c.getTypeComponant(), "Labor"))
                .forEach(c -> {
                    if (c instanceof Labor l) {
                        displayLaborDetails(l, calcWorkCost(l));
                        priceAvantTVA.updateAndGet(v -> (double) (v + calcWorkCost(l)));
                        priceAvecTVA.updateAndGet(v -> (double) (v + calcWorkCostWithTVA(l, l.getTauxTVA())));
                    }
                });
        header("**Coût total de la main-d'œuvre avant TVA : " + priceAvantTVA + " €**");
        header("**Coût total de la main-d'œuvre avec TVA (" + components.getFirst().getTauxTVA() + ") : " + priceAvecTVA + " €**");
        header("3. Coût total avant marge : " + projet.getCoutTotal() + " €");
        header("4.Marge bénéficiaire (" + projet.getMargeBeneficiaire() + ") : " + projet.getCoutTotal() / projet.getMargeBeneficiaire() + " €");
        header("**Coût total final du projet : **" + (projet.getCoutTotal() / projet.getMargeBeneficiaire()) + projet.getCoutTotal() + " €");
    }

    public static void saveSuccessful() {
        header("--- Fin du projet ---");
    }

    private static void displayMaterielDetails(Materials m, double fullPriceNoTVA) {
        header("- " + m.getNom() + " : " + fullPriceNoTVA + " € (quantité : " + m.getQuantite() + " m², coût unitaire : " + m.getCoutUnitaire() + " €/m², qualité : " + m.getCoefficientQualite() + ", transport : " + m.getCoutTransport() + " €");
    }

    private static void displayLaborDetails(Labor l, double fullPriceNoTVA) {
        header("- " + l.getNom() + " : " + fullPriceNoTVA + " € (taux horaire : " + l.getHourlyRate() + " €/h, heures travaillées : " + l.getHoursWorked() + " h, productivité : " + l.getWorkerProductivity());
    }

    private static double calcWorkCost(Labor l) {
        return l.getHourlyRate() * l.getHoursWorked() * l.getWorkerProductivity();
    }

    private static double calcWorkCostWithTVA(Labor entity, double TVA) {
        double tax = (calcWorkCost(entity) * TVA) / 100;
        return calcWorkCost(entity) + tax;
    }

    private static double calcUnitCost(Materials m) {
        return (m.getQuantite() * m.getCoutUnitaire() * m.getCoefficientQualite()) + m.getCoutTransport();
    }

    private static double calcUnitCostWithTVA(Materials m, double TVA) {
        double tax = (calcUnitCost(m) * TVA) / 100;
        return calcUnitCost(m) + tax;
    }
}
