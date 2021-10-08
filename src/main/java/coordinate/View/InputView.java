package coordinate.View;


import coordinate.Model.Figure;
import coordinate.Model.FigureFactory;
import coordinate.Model.Line;
import coordinate.Model.Point;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {


    private static final String ERROR_MESSAGE = "옳바르지 않은 좌표 입니다.";
    private static final String ERROR_NUMBER = "24 이하의 숫자를 입력 해 주세요";

    public static Figure Input() {
        System.out.println("좌표를 입력하세요");
        Scanner sc = new Scanner(System.in);
        String lines = sc.nextLine();
        isValidNumber(lines);
        return createPoints(lines);
    }

    public static Figure createPoints(String Lines) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
        Matcher matcher = pattern.matcher(Lines.trim());

        if(!matcher.find()) {

            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return createPoint(Lines);
    }

    private static Figure createPoint(String coordinate) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(coordinate);
        List<Point> points = new ArrayList<>();

        while (matcher.find()) {
            points.add(new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }
        Figure figure = FigureFactory.create(points);
        return figure;
    }

    private static void isValidNumber(String lines) {
        try {
            Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
            Matcher matcher = pattern.matcher(lines);

            while (matcher.find()) {
                if (Integer.parseInt(matcher.group(1)) > 24 || Integer.parseInt(matcher.group(2)) > 24) {
                    throw new IllegalArgumentException(ERROR_NUMBER);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Input();
        }
    }
}
