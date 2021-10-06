package Coordinate.Model;

import java.util.List;

public class Line extends AbstractFigure {

    private static final String AREA_INFO ="두 점 사이 거리는 ";

    Line(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        return getPoints().get(0).getSqrt(getPoints().get(1));
    }

    @Override
    public String areaInfo() {
        return AREA_INFO + area();
    }
}
