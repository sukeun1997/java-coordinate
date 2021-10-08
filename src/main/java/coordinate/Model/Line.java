package coordinate.Model;

import java.util.List;
import java.util.Objects;

public class Line extends AbstractFigure {

    private static final String ERROR_MESSAGE = "선이 아닙니다.";
    private static final String LINE_MESSAGE = "두 점 사이 거리는 ";
    public Line(List<Point> points) {
        super(points);
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
        return Objects.equals(getPoints(), line.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints());
    }

    public double area() {
        return getPoints().get(0).sqrt(getPoints().get(1));
    }

    public String areaInfo() {
        return LINE_MESSAGE + area();
    }

}
