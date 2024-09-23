package Views.ComponentView;

import Views.View;

public class GetComponentDetailsView extends View {
    public static String getComponentName() {
        return getStringInput(new String[]{"Entrez le nom du composent :"});
    }
}
