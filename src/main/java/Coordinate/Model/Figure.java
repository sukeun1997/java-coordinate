package Coordinate.Model;

import java.util.List;

public interface Figure {

    List<Point> getPoints();

    double area();

    String areaInfo();
}
