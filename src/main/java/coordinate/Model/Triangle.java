package coordinate.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Triangle extends AbstractFigure{


    Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        ArrayList<Double> linelist = ConvertToLine(getPoints());
        double s = getLineS();
        double a = linelist.get(0);
        double b = linelist.get(1);
        double c = linelist.get(2);
        return Math.round(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    private double getLineS() {
        return ConvertToLine(getPoints()).stream().mapToDouble(n -> n).sum() / 2;

    }

    @Override
    public String areaInfo() {
        return null;
    }

    public ArrayList<Double> ConvertToLine(List<Point> points) {
        ArrayList<Double> LineList = new ArrayList<>();
        LineList.add(points.get(0).sqrt(points.get(1)));
        LineList.add(points.get(1).sqrt(points.get(2)));
        LineList.add(points.get(2).sqrt(points.get(0)));
        return LineList;
    }
}
