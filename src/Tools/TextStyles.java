package Tools;

public class TextStyles {
    public static void header(String header) {
        System.out.println("--- " + header + " ---");
    }

    public static void asterisksText(String asterisksText) {
        System.out.println("*** "+asterisksText+" ***");
    }

    public static void bold (String bold) {
        System.out.println("** "+bold+" **");
    }

    public static void text (String text) {
        System.out.println(text);
    }

    public static void options(String[] options) {
        int i = 1;
        for (String option : options)
            System.out.println(i++ + ". " + option);
    }

    public static void footer(String footer) {
        System.out.println(footer);
    }

    public static void error(String error) {
        System.out.println("***WARNING*** : " + error);
    }

    public static void success(String success) {
        System.out.println("Success : " + success);
    }
}
