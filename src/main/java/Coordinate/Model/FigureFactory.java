package Coordinate.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final int FIGURE_LINE = 2;
    private static final int FIGURE_RECT = 4;
    private static final int FIGURE_TRIANGLE = 3;
    private static final Map<Integer, Function<List<Point>, Figure>> classifer = new HashMap<>();

//    static {
//        classifer.put(FIGURE_LINE, Line);
//    }

}