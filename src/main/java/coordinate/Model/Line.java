package coordinate.Model;

import java.util.List;
import java.util.Objects;

public class Line {

    private static final String ERROR_MESSAGE = "선이 아닙니다.";
    private static final String LINE_MESSAGE = "두 점 사이 거리는 ";

    private final List<Point> points;

    public Line(List<Point> points) {
        isLine(points);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    private void isLine(List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point1 -> point1.isSame(x,y));
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

    public double area() {
        return points.get(0).sqrt(points.get(1));
    }

    public String areaInfo() {
        return LINE_MESSAGE + area();
    }

}
