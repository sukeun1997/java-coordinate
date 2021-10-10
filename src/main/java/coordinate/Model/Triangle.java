package coordinate.Model;

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
}
