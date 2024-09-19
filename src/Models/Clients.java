package Models;

public class Clients {
    private final long client_id;
    private String nom;
    private String adresse;
    private String telephone;
    private boolean estProfessionnel;

    public Clients(long clientId, String clientNom, String clientAdresse, String clientTel, boolean estProfessionnel) {
        this.client_id = clientId;
        this.nom = clientNom;
        this.adresse = clientAdresse;
        this.telephone = clientTel;
        this.estProfessionnel = estProfessionnel;
    }

    public long getClient_id() {
        return client_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean getEstProfessionnel() {
        return this.estProfessionnel;
    }

    public void setEstProfessionnel(boolean estProfessionnel) {
        this.estProfessionnel = estProfessionnel;
    }
}
