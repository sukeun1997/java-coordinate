package Coordinate.Model;

import java.util.List;

public abstract class AbstractFigure implements Figure{

    private final List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

}
