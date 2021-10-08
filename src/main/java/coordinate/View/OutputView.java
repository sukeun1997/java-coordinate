package coordinate.View;

public class OutputView {

    public static final int End = 24;
    public static final int Start = 1;
    private static final String EMPTY = "\n";
    private static final String BLANK = "    ";
    private static final String BAR = "|";
    private static final String LINE = "----";

    public static void init() {
        for (int i = End; i >= Start; i--) {
            ShowHorizontal(i);
            Print(EMPTY);
        }
        ShowHorizontal();
    }

    private static void ShowHorizontal() {
        Print(BLANK);
        for (int i = 0; i <= End ; i++) {
            if (i == 0) {
                Print("+");
                continue;
            }
            Print(LINE);
        }

        ShowNumberX();
    }

    private static void ShowNumberX() {
        Print(EMPTY);
        for (int i = 0; i <= End ; i++) {
            ShowAxisNumber(i);
        }
    }

    private static void ShowHorizontal(int i) {
        ShowAxisNumber(i);
        Print(BAR);
        Print(BLANK);
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
