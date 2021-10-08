package coordinate.View;

import coordinate.Model.Line;
import coordinate.Model.Point;

public class OutputView {

    public static final int End = 24;
    public static final int Start = 0;
    private static final String EMPTY = "\n";
    private static final String BLANK = "    ";
    private static final String BAR = "|";
    private static final String LINE = "----";
    private static final String DOT = ".";

    public static void init(Line line) {
        for (int i = End; i > Start; i--) {
            ShowVertical(i);
            ShowPoint(line, i);
            Print(EMPTY);
        }
        ShowHorizontal();
        isEnd();
    }

    private static void isEnd() {
        Print(EMPTY);
        Print(EMPTY);
    }

    private static void ShowPoint(Line line, int y) {
            for (int x = 1; x <= End ; x++) {
                if (line.hasPoint(x,y)) {
                    Print(DOT);
                    continue;
                }
                    Print(BLANK);
            }
    }

    private static void ShowHorizontal() {
        Print(BLANK);
        for (int i = Start; i <= End ; i++) {
            if (i == Start) {
                Print("+");
                continue;
            }
            Print(LINE);
        }

        ShowNumberX();
    }

    private static void ShowNumberX() {
        Print(EMPTY);
        for (int i = Start; i <= End ; i++) {
            ShowAxisNumber(i);
        }
    }

    private static void ShowVertical(int i) {
            ShowAxisNumber(i);
            Print(BAR);
    }

    private static void ShowAxisNumber(int i) {
        if(i % 2 == 0) {
            Print(String.format("%4d", i));
            return;
        }
            Print(BLANK);
    }

    private static void Print(String empty) {
        System.out.print(empty);
    }
    
}
