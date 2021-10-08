package coordinate.Controller;

import coordinate.Model.Line;
import coordinate.View.InputView;
import coordinate.View.OutputView;

public class CoordinateCirculator {
    public static void run() {
        Line line = InputView.Input();
        OutputView.init(line);
        System.out.println(line.areaInfo());
//        InputView.Input();

    }
}
