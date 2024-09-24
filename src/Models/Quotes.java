package Models;

import java.time.LocalDate;

public class Quotes {
    private final long quote_id;
    private double montantEstime;
    private LocalDate dateEmission;
    private LocalDate dateValidate;
    private boolean accepte;
    private long projectId;

    public Quotes(long quoteId, double montantEstime, LocalDate dateEmission, LocalDate dateValidate, boolean accepte, long projectId) {
        this.quote_id = quoteId;
        this.montantEstime = montantEstime;
        this.dateEmission = dateEmission;
        this.dateValidate = dateValidate;
        this.accepte = accepte;
        this.projectId = projectId;
    }

    public long getQuote_id() {
        return quote_id;
    }

    public double getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(double montantEstime) {
        this.montantEstime = montantEstime;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public LocalDate getDateValidate() {
        return dateValidate;
    }

    public void setDateValidate(LocalDate dateValidate) {
        this.dateValidate = dateValidate;
    }

    public boolean isAccepte() {
        return this.accepte;
    }

    public void setIsAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
