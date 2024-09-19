package Tools;

import java.util.Scanner;

public class ScannerCast {

    private ScannerCast() {
    }

    private static class ScannerCastHelper {
        private static final Scanner INSTANCE = new Scanner(System.in);
    }

    public static Scanner readIn() {
        return ScannerCastHelper.INSTANCE;
    }

    public static void emptyInputBuffer() {
        readIn().nextLine();
    }
}
