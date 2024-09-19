package Models;

public class Materiaux {
    private final long materiau_id;
    private String nom;
    private double coutUnitaire;
    private double quantite;
    private String typeComposant;
    private double tauxTVA;
    private double coutTransport;
    private double coefficientQualite;

    public Materiaux(long materiau_id, String nom, double coutUnitaire, double quantite, double tauxTVA, String typeComposant, double coutTransport, double coefficientQualite) {
        this.materiau_id = materiau_id;
        this.nom = nom;
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.tauxTVA = tauxTVA;
        this.typeComposant = typeComposant;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    }

    public long getMateriau_id() {
        return materiau_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public String getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(String typeComposant) {
        this.typeComposant = typeComposant;
    }

    public double getCoutTransport() {
        return coutTransport;
    }

    public void setCoutTransport(double coutTransport) {
        this.coutTransport = coutTransport;
    }

    public double getCoefficientQualite() {
        return coefficientQualite;
    }

    public void setCoefficientQualite(double coefficientQualite) {
        this.coefficientQualite = coefficientQualite;
    }
}
