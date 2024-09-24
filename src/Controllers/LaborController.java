package Controllers;

import Models.Labor;
import Views.ComponentView.GetComponentDetailsView;
import Views.LaborView.GetLaborDetailsView;
import Views.LaborView.LaborView;

import java.util.ArrayList;
import java.util.List;

public class LaborController extends Controller{
    public LaborController() {
        super();
    }

    public List<Labor> gatherLaborObjs() {
        boolean continueCreating = true;
        List<Labor> labors = new ArrayList<>();
        Labor labor;

        LaborView.displayMenu();
        while (continueCreating) {
            LaborView.displaySize(labors.size()+1);
            labor = createNewLaborObj();
            labors.add(labor);
            LaborView.saveSuccessful();
            continueCreating = LaborView.askToContinue();
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
