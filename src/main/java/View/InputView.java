package View;

import Coordinate.Model.FigureFactory;
import Coordinate.Model.Point;
import Coordinate.Model.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";

    public static void input() {
        System.out.println("좌표를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        create(sc.nextLine());
    }

    private static void create(String line) {

        Validation.isValidationLineInput(line);
        generatePoint(line);
    }

    public static Point generatePoint(String line) {

        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(line);


        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
    }

    public static List<Point> generatePoints(String lines) {

        List<Point> points = new ArrayList<>();
        for (String s : lines.split("-")) {
            points.add(generatePoint(s));
        }
        return points;
    }
}