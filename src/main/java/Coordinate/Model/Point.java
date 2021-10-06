package Coordinate.Model;

import java.util.Objects;

public class Point {

    private final double x;
    private final double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSqrt(Point point) {
        return Math.sqrt(getPow(point));
    }

    public double getPow(Point point) {
        return Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
