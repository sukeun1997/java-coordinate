import Coordinate.Line.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateLineTest {

    @ParameterizedTest
    @CsvSource(value = {"(10,10):true", "[10,10]:false", "(10.10):false"}, delimiter = ':')
    void 좌표_입력_검증(String input, boolean expected) {
        assertEquals(Validation.isLine(input), expected);
    }

    @Test
    void 좌표_null_blank_empty_검증() {
        assertThat(Validation.isLine(" ")).isEqualTo(false);
        assertThat(Validation.isLine(null)).isEqualTo(false);
        assertThat(Validation.isLine("")).isEqualTo(false);
    }

    @Test
    void 좌표_생성() {
        String s = "(10,10)";
        s = s.substring(1, s.length() - 1);
        String[] Line = s.split(",");
        Line line = new Line(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]));
        assertThat(line).isEqualTo(new Line(10, 10));
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10):true", "(25,10):false", "(10,25):false"}, delimiter = ':')
    void 좌표_x_y_최대값_검증(String input , boolean expected) {
        input = input.substring(1, input.length() - 1);
        String[] Line = input.split(",");
        Line line = new Line(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]));
        assertEquals(line.isAvalibleLine(line), expected);
    }
}
