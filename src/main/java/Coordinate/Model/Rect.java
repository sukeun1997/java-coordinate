package Coordinate.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Rect extends AbstractFigure {

    private final static String AREA_INFO = "사각형 넓이는 ";

    Rect(List<Point> points) {
        super(points);
    }

    private Set<Integer> ConvertX(List<Point> points) {
        return points.stream().map(point -> point.getX()).collect(Collectors.toSet());
    }
    private Set<Integer> ConvertY(List<Point> points) {
        return points.stream().map(point -> point.getY()).collect(Collectors.toSet());
    }

    private int CalculateDifference(Set<Integer> set) {
        List<Integer> values = new ArrayList<>(set);
        return Math.abs(values.get(0)-values.get(1));
    }

    @Override
    public double area() {
        List<Point> points = this.getPoints();
        return CalculateDifference(ConvertX(points)) * CalculateDifference(ConvertY(points));
    }

    @Override
    public String areaInfo() {
        return AREA_INFO + (int) area();
    }
}
