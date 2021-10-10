package coordinate.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final Map<Integer, Function<List<Point>, Figure>> classifer = new HashMap<>();

    private static final Integer FIGURE_RECTANGLE = 4;
    private static final Integer FIGURE_LINE = 2;
    private static final Integer FOGURE_TRIANGLE = 3;

    static {
        classifer.put(FIGURE_LINE, Line::new);
        classifer.put(FIGURE_RECTANGLE, Rectangle::new);
        classifer.put(FOGURE_TRIANGLE, Triangle::new);
    }

    public static Figure create(List<Point> points) {
        isFigure(points);
        return classifer.get(points.size()).apply(points);
    }

    private static void isFigure(List<Point> points) {
        if (points.size() < 1 && points.size() > 4) {
            throw new IllegalArgumentException("옳바른 좌표를 입력해 주세요");
        }
    }
}
