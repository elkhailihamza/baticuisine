package Tools;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class GetValue {
    private static final Scanner scannerInstance = ScannerCast.readIn();

    private static void clearUserInput() {
        ScannerCast.emptyInputBuffer();
    }

    public static String stringValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextLine()) {
                return scannerInstance.nextLine();
            } else {
                TextStyles.error("Not a valid String!");
                clearUserInput();
            }
        }
    }

    public static int validNum(int optionLength) {
        if (scannerInstance.hasNextInt()) {
            int option = scannerInstance.nextInt();
            clearUserInput();
            if (option >= 1 && option <= optionLength) {
                return option;
            }
            TextStyles.error("Invalid choice!");
            return -1;
        }

        TextStyles.error("Invalid input!");
        clearUserInput();
        return -1;
    }

    public static int integerValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextInt()) {
                int value = scannerInstance.nextInt();
                clearUserInput();
                return value;
            } else {
                TextStyles.error("Not a valid Int!");
                clearUserInput();
            }
        }
    }

    public static double doubleValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextDouble()) {
                double value = scannerInstance.nextDouble();
                clearUserInput();
                return roundDouble(value);
            } else {
                TextStyles.error("Not a valid Double!");
                clearUserInput();
            }
        }
    }

    private static double roundDouble(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static long longValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextLong()) {
                long value = scannerInstance.nextLong();
                clearUserInput();
                return value;
            } else {
                TextStyles.error("Not a valid Double!");
                clearUserInput();
            }
        }
    }

    public static boolean booleanValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextBoolean()) {
                return scannerInstance.nextBoolean();
            } else {
                TextStyles.error("Not a valid Boolean!");
                clearUserInput();
            }
        }
    }

    public static boolean yOrNValue(String[] text) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);
            if (scannerInstance.hasNextLine()) {
                String value = scannerInstance.nextLine().trim();
                if (value.equalsIgnoreCase("Y"))
                    return true;
                else if (value.equalsIgnoreCase("N"))
                    return false;
                clearUserInput();
            }
            TextStyles.error("Only a Y or N value is allowed!");
        }
    }

    public static LocalDate localDateValue(String[] text, String pattern) {
        while (true) {
            Arrays.stream(text).forEach(System.out::println);

            if (scannerInstance.hasNext()) {
                String input = scannerInstance.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    return LocalDate.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    TextStyles.error("Invalid date format!");
                }
            } else {
                TextStyles.error("Input is required!");
                clearUserInput();
            }
        }
    }

}
