package Coordinate.Model;

import java.util.Objects;

public class Line {

    private final double x;

    private final double y;
    public Line(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAvalibleLine(Line line) {
        return (0 < line.x && line.x <= 24) && (0 < line.y && line.y <= 24);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x == line.x && y == line.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
