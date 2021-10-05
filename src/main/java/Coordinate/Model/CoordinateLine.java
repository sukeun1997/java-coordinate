package Coordinate.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CoordinateLine {

    private final List<Line> lineList;

    public CoordinateLine(List<Line> lineList) {
        this.lineList = lineList;
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(lineList.get(0).getX()-lineList.get(1).getX() ,2) + Math.pow(lineList.get(0).getY()-lineList.get(1).getY() ,2));
    }

    public List<Line> getLineList() {
        return lineList;
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

    @Override
    public String toString() {
        return "두 점 사이 거리는 "+getDistance();
    }
}
