package coordinate.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    private static final String RECT_MESSAGE = "사각형의 넓이는 ";
    private static final String ERROR_MESSAGE = "직사각형이 아닙니다.";

    public Rectangle(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        getDiagonalFirst(getPoints());
        int x = getHorizontal(ConvertToLineX(getPoints()));
        int y = getVertical(ConvertToLineY(getPoints()));
        return x*y;
    }

    @Override
    public String areaInfo() {
        return RECT_MESSAGE + area();
    }

    public List<Integer> ConvertToLineX(List<Point> points) {
        return points.stream().map(Point::getX).distinct().toList();
    }

    public List<Integer> ConvertToLineY(List<Point> points) {
        return points.stream().map(Point::getY).distinct().toList();
    }

    public int getHorizontal(List<Integer> HorizontalList) {
        return Math.abs(HorizontalList.get(0) - HorizontalList.get(1));
    }

    public int getVertical(List<Integer> VerticalList) {
        return Math.abs(VerticalList.get(0) - VerticalList.get(1));
    }

    private List<Point> getDiagonalFirst(List<Point> points) {
        List<Point> list = points.stream()
                .filter(point -> point != points.get(0))
                .filter(point -> points.get(0).getX() == point.getX() || point.getY() == points.get(0).getY())
                .toList();
        return list;
    }

    public void isRectangle(List<Point> points) {
        List<Point> diagonalFirst = getDiagonalFirst(points);
        Point point = points.stream().filter(point1 -> point1 != points.get(0)).filter(point1 -> !diagonalFirst.contains(point1)).findFirst().get();
        double Line1 = diagonalFirst.get(0).sqrt(diagonalFirst.get(1));
        double Line2 = points.get(0).sqrt(point);

        if (Line1 != Line2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
