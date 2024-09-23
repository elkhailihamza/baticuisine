package Views.MaterialView;

import Views.View;

public class MaterialView extends View {
    public static boolean askToContinue() {
        return getYValue(new String[]{"Voulez-vous ajouter un autre matériau ? (y/n) :"});
    }
}
