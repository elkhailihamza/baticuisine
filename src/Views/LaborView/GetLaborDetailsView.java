package Views.LaborView;

import Views.View;

public class GetLaborDetailsView extends View {
    public static double getHourlyRate() {
        return getDoubleValue(new String[]{"Entrez le taux horaire de cette main-d'œuvre (€/h) :"});
    }

    public static double getHoursWorked() {
        return getDoubleValue(new String[]{"Entrez le nombre d'heures travaillées :"});
    }

    public static double getWorkerProductivity() {
        return getDoubleValue(new String[]{"Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) :"});
    }
}
