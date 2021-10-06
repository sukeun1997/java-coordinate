package Coordinate.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";

    private static boolean isNoInput(String input) {
        return input.isBlank() || input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }


    public static boolean isValidationLineInput(String input) {

        try {

            if (isNull(input)) {
                throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
            }
            Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
            Matcher matcher = pattern.matcher(input);

            if (!matcher.matches() || isNoInput(input)) {
                throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
            }

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
