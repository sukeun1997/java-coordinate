package Coordinate;

import Coordinate.Model.Line;

import java.util.List;
import java.util.Objects;

public class CoordinateLine {

    private final List<Line> lineList;

    public CoordinateLine(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static Line create(String input) {
        input = input.substring(1, input.length() - 1);
        String[] Line = input.split(",");
        return new Line(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateLine that = (CoordinateLine) o;
        return Objects.equals(lineList, that.lineList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineList);
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(lineList.get(0).getX()-lineList.get(1).getX() ,2) + Math.pow(lineList.get(0).getY()-lineList.get(1).getY() ,2));
    }
}