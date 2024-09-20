package Models;

public class Components {
    private final long component_id;
    private String nom;
    private String typeComponant;
    private double tauxTVA;
    private long projectId;

    public Components(long component_id, String nom, String typeComponant, double tauxTVA, long projectId) {
        this.component_id = component_id;
        this.nom = nom;
        this.typeComponant = typeComponant;
        this.tauxTVA = tauxTVA;
        this.projectId = projectId;
    }

    public long getComponent_id() {
        return component_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeComponant() {
        return typeComponant;
    }

    public void setTypeComponant(String typeComponant) {
        this.typeComponant = typeComponant;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
