package View;

import Coordinate.Model.Figure;
import Coordinate.Model.Point;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String FOUR_BLANK = "    ";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "----";
    private static final String MARK_OF_POINT = ".";
    private static final String EMPTY_LINE = "\n";
    public static final int Max = 24;
    public static final int Min = 1;


    public static void Init(Figure points) {
        showYLine(points);
        ShowXLine();
        showHorizontalNumbers();
    }

    private static void showYLine(Figure points) {
        for (int y = Max; y >= Min; y--) {
            showAxisNumber(y);
            AppendText(VERTICAL_AXIS);
            showPoirnts(points, y);
            AppendText(EMPTY_LINE);
        }
    }

    private static void showPoirnts(Figure figure, int y) {
        for (int x = Min; x <= Max; x++) {
            if (figure.hasPoint(x, y)) {
                System.out.print(String.format("%4s", MARK_OF_POINT));
                continue;
            }
            System.out.print(FOUR_BLANK);
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

    private static void AppendText(String s) {
        System.out.print(s);
    }

}