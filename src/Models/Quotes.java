package Models;

import java.sql.Date;

public class Quotes {
    private final long devis_id;
    private double montantEstime;
    private Date dateEmission;
    private Date dateValidate;
    private boolean accepte;
    private long projectId;

    public Quotes(long devisId, double montantEstime, Date dateEmission, Date dateValidate, boolean accepte, long projectId) {
        this.devis_id = devisId;
        this.montantEstime = montantEstime;
        this.dateEmission = dateEmission;
        this.dateValidate = dateValidate;
        this.accepte = accepte;
        this.projectId = projectId;
    }

    public long getDevis_id() {
        return devis_id;
    }

    public double getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(double montantEstime) {
        this.montantEstime = montantEstime;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Date getDateValidate() {
        return dateValidate;
    }

    public void setDateValidate(Date dateValidate) {
        this.dateValidate = dateValidate;
    }

    public boolean getAccepte() {
        return this.accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
