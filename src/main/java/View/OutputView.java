package View;

import Coordinate.Model.Figure;
import Coordinate.Model.Point;

public class OutputView {
    private static final String FOUR_BLANK = "    ";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "----";
    private static final String MARK_OF_POINT = ".";
    private static final String EMPTY_LINE = "\n";
    public static final int Max = 24;
    public static final int Min = 1;
    static StringBuilder stringBuilder = new StringBuilder();


    public static void Init(Figure points) {
        showYLine(points);
        ShowXLine();
        showHorizontalNumbers();
        System.out.println(stringBuilder);
    }

    private static void showYLine(Figure points) {
        for (int y = Max; y >= Min; y--) {
            showAxisNumber(y);
            AppendText(VERTICAL_AXIS);
            showPoirnts(points, y);
            AppendText(EMPTY_LINE);
        }
    }

    private static void showPoirnts(Figure points, int y) {
        for (Point line : points.getPoints()) {
            if (line.getY() == y) {
                for (int x = Min; x < line.getX(); x++) {
                    stringBuilder.append(FOUR_BLANK);
                }
                stringBuilder.append(MARK_OF_POINT);
            }
        }
    }

    private static void ShowXLine() {
        AppendText(FOUR_BLANK+ORIGIN);
        for (int i = 0; i <= 24; i++) {
            AppendText(HORIZONTAL_AXIS);
        }
        AppendText(EMPTY_LINE);
    }

    private static void showAxisNumber(int index) {
        if (index % 2 == 0) {
            AppendText(String.format("%4d", index));
            return;
        }
        AppendText(FOUR_BLANK);
    }

    private static void showHorizontalNumbers() {
        for (int x = 0; x <= Max; x++) {
            showAxisNumber(x);
        }
        AppendText(EMPTY_LINE);
    }

    private static StringBuilder AppendText(String s) {
        return stringBuilder.append(s);
    }

}