package Views.ProjetView;

import Models.*;
import Tools.TextStyles;
import Views.LaborView.LaborView;
import Views.MaterialView.MaterialView;

import java.util.HashMap;

public class ProjetView {
    public static String createNewProject() {
        TextStyles.header("Création d'un Nouveau Projet");
        return GetProjetDetailsView.getProjetName();
    }

    public static void totalPriceResult(Projets projet, HashMap<Materials, Double> materials, HashMap<Labor, Double> labor, Clients client, double tauxTVA, double margeBenPourcentage, double totalPriceNoMarge, double priceMat, double priceMatTVA, double priceLab, double priceLabTVA) {
        TextStyles.header("Résultat du Calcul");
        TextStyles.text("Nom du projet :" + projet.getNomProjet());
        TextStyles.text("Client: " + client.getNom());
        TextStyles.text("Adresse du chantier :" + client.getAdresse());
        TextStyles.header("Détail des Coûts");
        TextStyles.text("1. Matériaux :");

        materials.keySet().forEach(k -> {
            double unitPrice = materials.get(k);
            MaterialView.displayMaterialComponent(k, unitPrice);
        });

        TextStyles.bold("Coût total des matériaux avant TVA : " + priceMat + " €");
        TextStyles.bold("Coût total des matériaux avec TVA (" + tauxTVA + ") : " + priceMatTVA + " €");
        TextStyles.text("2. Main-d'œuvre : ");

        labor.keySet().forEach(k -> {
            double unitPrice = labor.get(k);
            LaborView.displayLaborComponent(k, unitPrice);
        });

        TextStyles.bold("Coût total de la main-d'œuvre avant TVA : " + priceLab + " €");
        TextStyles.bold("Coût total de la main-d'œuvre avec TVA (" + tauxTVA + "%) : " + priceLabTVA + " €");
        TextStyles.text("3. Coût total avant marge : " + totalPriceNoMarge + " €");
        TextStyles.text("4.Marge bénéficiaire (" + margeBenPourcentage + ") : " + projet.getMargeBeneficiaire() + " €");
        TextStyles.bold("Coût total final du projet : ** " + projet.getCoutTotal() + " €");
    }

    public static void displayProjet(Projets p) {
        TextStyles.text("Id : "+p.getProjet_id()+"- nom : "+p.getNomProjet()+" | etat : "+p.getEtatProjet()+". Cout total : ("+p.getCoutTotal()+" €) marge beneficiaire : "+p.getMargeBeneficiaire()+" €.");
    }

    public static void displayProjetPrice(Projets p) {
        TextStyles.text("- "+p.getNomProjet()+" : "+p.getCoutTotal()+" €");
    }

    public static void projetNotFound(long id) {
        TextStyles.error("Projet not found with id "+id+" Not found!");
    }

    public static void saveSuccessful() {
        TextStyles.header("--- Fin du projet ---");
    }
}
