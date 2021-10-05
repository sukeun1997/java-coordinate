package Coordinate.Model;

public class Validation {

    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";

    public static boolean isValidationLineInput(String input) {
        try {

            if (isNull(input)) {
                throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
            }
            input = input.trim();
            if (!isInputContains(input) || isNoInput(input)) {
                throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            return false;
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

    public static Boolean isValidationLinesInput(String input) {
        if (input.contains("-")) {
            return true;
        }
        return false;
    }
}
