package coordinate.Model;

import java.util.List;
import java.util.Objects;

public class Line {

    private static final String ERROR_MESSAGE = "선이 아닙니다.";
    private final List<Point> points;

    public Line(List<Point> points) {
        isLine(points);
        this.points = points;
    }

    private void isLine(List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
