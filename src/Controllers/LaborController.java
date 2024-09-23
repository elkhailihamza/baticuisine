package Controllers;

import Models.Labor;
import Models.Materials;
import Views.ComponentView.GetComponentDetailsView;
import Views.LaborView.GetLaborDetailsView;
import Views.MaterialView.MaterialView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LaborController extends Controller{
    public LaborController() {
        super();
    }

    public List<Labor> gatherLaborObjs() {
        boolean continueCreating = true;
        List<Labor> labors = new ArrayList<>();
        while (continueCreating) {
            labors.forEach(labor -> {
                labor = createNewLaborObj();
            });
            continueCreating = MaterialView.askToContinue();
        }
        return labors;
    }

    public Labor createNewLaborObj() {
        String nom = GetComponentDetailsView.getComponentName();
        double hourlyRate = GetLaborDetailsView.getHourlyRate();
        double hoursWorked = GetLaborDetailsView.getHoursWorked();
        double workerProductivity = GetLaborDetailsView.getWorkerProductivity();

        return new Labor(1, nom, "Labor", 1, hourlyRate, hoursWorked, workerProductivity, 1);
    }
}
