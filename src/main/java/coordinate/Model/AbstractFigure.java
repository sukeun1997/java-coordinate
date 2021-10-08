package coordinate.Model;

import java.util.List;

public abstract class AbstractFigure implements Figure {


    private final List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }


    @Override
    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point1 -> point1.isSame(x,y));
    }


}
