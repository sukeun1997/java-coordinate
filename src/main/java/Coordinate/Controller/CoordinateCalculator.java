package Coordinate.Controller;

import Coordinate.Model.Figure;
import View.InputView;
import View.OutputView;

public class CoordinateCalculator {
    public static void run() {
        Figure figure = InputView.input();
        OutputView.Init(figure);
        System.out.println(figure.areaInfo());
    }
}
