package coordinate.Model;

import java.util.List;

public interface Figure {
    List<Point> getPoints();
    void hasPoint();
    double area();
    String areaInfo();
}
