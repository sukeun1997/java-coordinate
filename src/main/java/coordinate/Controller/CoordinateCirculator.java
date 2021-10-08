package coordinate.Controller;

import coordinate.Model.Figure;
import coordinate.Model.Line;
import coordinate.View.InputView;
import coordinate.View.OutputView;

public class CoordinateCirculator {
    public static void run() {
        Figure line = InputView.Input();
        OutputView.init(line);
        System.out.println(line.areaInfo());
//        InputView.Input();

    }
}
