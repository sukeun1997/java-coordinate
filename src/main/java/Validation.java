import Coordinate.Line.Line;

import java.util.Arrays;

public class Validation {
    public static boolean isLine(String input) {
        if (isNull(input)) {
            return false;
        }
        input = input.trim();
        if (!isInputContains(input) || isNoInput(input)) {
            return false;
        }
        return true;
    }

    private static boolean isNoInput(String input) {
        return input.isBlank() || input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isInputContains(String input) {
        return input.contains("(") && input.contains(")") && input.contains(",");
    }
}
