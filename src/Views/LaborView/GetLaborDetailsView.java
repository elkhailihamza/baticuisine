package Views.LaborView;

import Tools.GetValue;

public class GetLaborDetailsView {
    public static double getHourlyRate() {
        return GetValue.doubleValue(new String[]{"Entrez le taux horaire de cette main-d'œuvre (€/h) :"});
    }

    public static double getHoursWorked() {
        return GetValue.doubleValue(new String[]{"Entrez le nombre d'heures travaillées :"});
    }

    public static double getWorkerProductivity() {
        return GetValue.doubleValue(new String[]{"Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) :"});
    }
}
