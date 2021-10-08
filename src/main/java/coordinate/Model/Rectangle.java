package coordinate.Model;

import java.util.List;

public class Rectangle extends AbstractFigure {
    public Rectangle(List<Point> points) {
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
