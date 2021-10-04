package Coordinate.Line;

import java.util.Objects;

public class Line {

    private final int x;
    private final int y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAvalibleLine(Line line) {
        return (0 < line.x && line.x <= 24) && (0 < line.y && line.y <= 24);
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
