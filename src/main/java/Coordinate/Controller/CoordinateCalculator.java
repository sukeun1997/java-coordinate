package Coordinate.Controller;

import Coordinate.Model.Figure;
import Coordinate.View.InputView;
import Coordinate.View.OutputView;

public class CoordinateCalculator {
    public static void run() {
        Figure figure = InputView.input();
        OutputView.Init(figure);
        System.out.println(figure.areaInfo());
    }
}
