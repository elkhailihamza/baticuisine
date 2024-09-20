package Models;

public class Labors {
    private final long mainOeuvre_id;
    private String nom;
    private String typeComposant;
    private double tauxTVA;
    private double tauxHoraire;
    private double heuresTravail;
    private double productiviteOuvrier;
    private long projectId;

    public Labors(long mainOeuvre_id, String nom, String typeComposant, double tauxTVA, double tauxHoraire, double heuresTravail, double productiviteOuvrier, long projectId) {
        this.mainOeuvre_id = mainOeuvre_id;
        this.nom = nom;
        this.typeComposant = typeComposant;
        this.tauxTVA = tauxTVA;
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;
        this.projectId = projectId;
    }

    public long getMainOeuvre_id() {
        return mainOeuvre_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(String typeComposant) {
        this.typeComposant = typeComposant;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setHeuresTravail(double heuresTravail) {
        this.heuresTravail = heuresTravail;
    }

    public double getHeuresTravail() {
        return heuresTravail;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
