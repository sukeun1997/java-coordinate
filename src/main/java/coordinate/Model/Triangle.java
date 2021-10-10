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
        return 0;
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
