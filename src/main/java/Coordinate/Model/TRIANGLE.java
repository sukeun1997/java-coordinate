package Coordinate.Model;

import Coordinate.Model.AbstractFigure;
import Coordinate.Model.Point;

import java.util.ArrayList;
import java.util.List;

public class TRIANGLE extends AbstractFigure {

    private final static String AREA_INFO = "삼각형 넓이는 ";
    private final static String ERROR_MESSAGE = "삼각형이 아닙니다.";

    public TRIANGLE(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        List<Double> lineList = ConvertToLine(getPoints());
        double a = lineList.get(0);
        double b = lineList.get(1);
        double c = lineList.get(2);
        double s = LineSum(lineList);
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
        CheckTriangle(line);
        return line;
    }

    private Double LineSum(List<Double> line) {
        return line.stream().mapToDouble(Number::doubleValue).sum() / 2;
    }

    private void CheckTriangle(List<Double> line){
        if (2 * getMaxLine(line) < LineSum(line).intValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private int getMaxLine(List<Double> line) {
        return line.stream().mapToInt(Double::intValue).max().getAsInt();
    }


}
