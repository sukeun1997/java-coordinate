package coordinate.Model;

import java.util.Objects;

public class Point {
    private final int x;

    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(int x ,int y) {
        return x == getX() && y == getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double sqrt(Point point) {
        return Math.sqrt(point.pow(x,point.x)+point.pow(y,point.y));
    }

    private double pow(int a, int b) {
        return Math.pow(a - b, 2);
    }
}
