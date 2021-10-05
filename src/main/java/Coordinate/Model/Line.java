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

    public static Line create(String input) {
        if(Validation.isValidationLineInput(input)) {
            input = input.substring(1, input.length() - 1);
            String[] Line = input.split(",");
            return new Line(Integer.parseInt(Line[0]), Integer.parseInt(Line[1]));
        }
        return null;
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
