package Models;

import Enums.Etat;

public class Projets {
    private final long projet_id;
    private String nomProjet;
    private double margeBeneficiaire;
    private double coutTotal;
    private Etat etatProjet;
    private long clientId;

    public Projets(long projet_id, String nomProjet, double margeBeneficiaire, double coutTotal, Etat etatProjet, long clientId) {
        this.projet_id = projet_id;
        this.nomProjet = nomProjet;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet = etatProjet;
        this.clientId = clientId;
    }

    public Projets(long projetId) {
        this.projet_id = projetId;
    }

    public long getProjet_id() {
        return projet_id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public double getMargeBeneficiaire() {
        return margeBeneficiaire;
    }

    public void setMargeBeneficiaire(double margeBeneficiaire) {
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Etat getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(Etat etatProjet) {
        this.etatProjet = etatProjet;
    }
}
