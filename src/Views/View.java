package Views;

public class View {
    public static void header(String header) {
        System.out.println(header);
    }

    public static void options(String[] options) {
        int i = 1;
        for (String option:options)
            System.out.println(i+". "+option);
    }

    public static void footer(String footer) {
        System.out.println(footer);
    }
}
