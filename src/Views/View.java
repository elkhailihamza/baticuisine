package Views;

import Tools.ScannerCast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class View {
    protected static Scanner scannerInstance = scanUserInput();

    protected static void header(String header) {
        System.out.println("--- "+header+" ---");
    }

    protected static void options(String[] options) {
        int i = 1;
        for (String option : options)
            System.out.println(i++ + ". " + option);
    }

    protected static void footer(String footer) {
        System.out.println(footer);
    }

    protected static void error(String error) {
        System.out.println("***WARNING*** : " + error);
    }

    protected static void success(String success) {
        System.out.println("Success : " + success);
    }

    protected static Scanner scanUserInput() {
        return ScannerCast.readIn();
    }

    protected static void clearUserInput() {
        ScannerCast.emptyInputBuffer();
    }

    protected static int returnValidNum(String[] options) {
        if (scannerInstance.hasNextInt()) {
            int option = scannerInstance.nextInt();
            clearUserInput();
            if (option >= 1 && option <= options.length) {
                return option;
            }
            error("Invalid choice!");
            return -1;
        }

        error("Invalid input! Please enter a number.");
        clearUserInput();
        return -1;
    }

    protected static boolean checkIfInputIsY() {
        return scannerInstance.hasNextLine() && scannerInstance.nextLine().equalsIgnoreCase("Y");
    }

    protected static String getStringInput(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextLine()) {
                return scannerInstance.nextLine();
            } else {
                error("Not a valid name!");
                clearUserInput();
            }
        }
    }

    protected static int getIntegerValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextInt()) {
                int value = scannerInstance.nextInt();
                clearUserInput();
                return value;
            } else {
                error("Not a valid name!");
                clearUserInput();
            }
        }
    }

    protected static boolean getBooleanValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextBoolean()) {
                return scannerInstance.nextBoolean();
            } else {
                error("Not a valid name!");
                clearUserInput();
            }
        }
    }

    protected static double getDoubleValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextDouble()) {
                return scannerInstance.nextDouble();
            } else {
                error("Not a valid name!");
                clearUserInput();
            }
        }
    }

    protected static boolean getYValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (checkIfInputIsY()) {
                return true;
            } else {
                error("Not a valid name!");
                clearUserInput();
            }
        }
    }

    protected static LocalDate getLocalDateValue(String[] text, String pattern) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);

            if (scannerInstance.hasNext()) {
                String input = scannerInstance.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    return LocalDate.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    error("Invalid date format! Please try again.");
                    clearUserInput();
                }
            } else {
                error("Input is required!");
                clearUserInput();
            }
        }
    }

}
