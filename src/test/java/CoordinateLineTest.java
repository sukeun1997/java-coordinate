import Coordinate.Model.CoordinateLine;
import Coordinate.Model.Line;
import Coordinate.Model.Validation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateLineTest {

    @ParameterizedTest
    @CsvSource(value = {"(10,10):true", "[10,10]:false", "(10.10):false"}, delimiter = ':')
    void 좌표_입력_검증(String input, boolean expected) {
        assertEquals(Validation.isValidationLineInput(input), expected);
    }

    @Test
    void 좌표_null_blank_empty_검증() {
        assertThat(Validation.isValidationLineInput(" ")).isEqualTo(false);
        assertThat(Validation.isValidationLineInput(null)).isEqualTo(false);
        assertThat(Validation.isValidationLineInput("")).isEqualTo(false);
    }

    @Test
    void 좌표_생성() {
        String s = "(10,10)";
        assertThat(Line.create(s)).isEqualTo(new Line(10, 10));
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10):true", "(25,10):false", "(10,25):false", "(-1,25):false"}, delimiter = ':')
    void 좌표_x_y_최대값_검증(String input , boolean expected) {
        input = input.substring(1, input.length() - 1);
        String[] Line = input.split(",");
        Line line = new Line(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]));
        assertEquals(line.isAvalibleLine(line), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15):true", "(10,10).(14,15):false"}, delimiter = ':')
    void 좌표_2개_입력_검증(String input , boolean expected) {
        assertEquals(Validation.isValidationLinesInput(input), expected);
    }

    private CoordinateLine createLines() {
        String s = "(10,10)-(14,15)";
        String[] Lines = s.split("-");
        List<Line> list = new ArrayList<>();
        Arrays.stream(Lines).forEach(input -> list.add(Line.create(input)));
        return new CoordinateLine(list);
    }

    @Test
    void 좌표_2개_생성() {
        CoordinateLine coordinateLine = createLines();
        assertEquals(coordinateLine,new CoordinateLine(Arrays.asList(new Line(10,10), new Line(14,15))));
    }

    @Test
    void 좌표_2개_거리() {
        CoordinateLine coordinateLine = createLines();
        assertEquals(coordinateLine.getDistance(), 6.403124, 0.001);
    }
}
