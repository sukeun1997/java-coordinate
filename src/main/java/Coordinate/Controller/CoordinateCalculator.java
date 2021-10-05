package Coordinate.Controller;

import Coordinate.Model.CoordinateLine;
import View.InputView;
import View.OutputView;

public class CoordinateCalculator {
    public static void run() {
        CoordinateLine coordinateLine = InputView.input();
        OutputView.Init(coordinateLine);
        System.out.println(coordinateLine);
    }
}
