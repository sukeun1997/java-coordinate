package Coordinate.Model;

import Coordinate.Model.AbstractFigure;
import Coordinate.Model.Point;

import java.util.ArrayList;
import java.util.List;

public class TRIANGLE extends AbstractFigure {

    private final static String AREA_INFO = "삼각형 넓이는 ";

    public TRIANGLE(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        double a = ConvertToLine(getPoints()).get(0);
        double b = ConvertToLine(getPoints()).get(1);
        double c = ConvertToLine(getPoints()).get(2);
        double s = LineSum(ConvertToLine(getPoints()));
        return Math.round(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public String areaInfo() {
        return AREA_INFO + area();
    }

    public List<Double> ConvertToLine(List<Point> points) {
        List<Double> line = new ArrayList<>();
        line.add(points.get(0).getSqrt(points.get(1)));
        line.add(points.get(1).getSqrt(points.get(2)));
        line.add(points.get(0).getSqrt(points.get(2)));
        return line;
    }

    private Double LineSum(List<Double> line) {
        return line.stream().mapToDouble(Number::doubleValue).sum() / 2;
    }

}
