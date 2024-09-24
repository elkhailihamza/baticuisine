package Models;

public class Labor extends Components{
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public Labor(long component_id, String nom, String typeComponant, double tauxTVA, double hourlyRate, double hoursWorked, double workerProductivity, long projetId) {
        super(component_id, nom, typeComponant, tauxTVA, projetId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkerProductivity() {
        return workerProductivity;
    }

    public void setWorkerProductivity(double workerProductivity) {
        this.workerProductivity = workerProductivity;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
