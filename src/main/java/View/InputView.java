package View;

import Coordinate.Model.CoordinateLine;
import Coordinate.Model.Line;
import Coordinate.Model.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {


    public static CoordinateLine input() {
        System.out.println("좌표를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        return create(sc.nextLine());
    }

    private static CoordinateLine create(String line) {

        Validation.isValidationLinesInput(line);

        String[] Lines = line.split("-");
        List<Line> list = new ArrayList<>();
        Arrays.stream(Lines).forEach(input -> list.add(Line.create(input)));
        return new CoordinateLine(list);
    }
}