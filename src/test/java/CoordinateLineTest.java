import Coordinate.Model.Line;
import Coordinate.Model.Point;
import Coordinate.Model.Validation;
import View.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateLineTest {

    @Test
    void 좌표_null_blank_empty_검증() {
        assertThat(Validation.isValidationLineInput(" ")).isEqualTo(false);
        assertThat(Validation.isValidationLineInput(null)).isEqualTo(false);
        assertThat(Validation.isValidationLineInput("")).isEqualTo(false);
    }

    @Test
    void 좌표_확인() {
        Point point = new Point(10, 10);
        assertEquals(point,new Point(10,10));
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15):true", "(10,10).(14,15):false", "(10,10)-(22,10)-(22,18)-(10,18):true"}, delimiter = ':')
    void 좌표_입력_검증(String input , boolean expected) {
        input.replace(" ", "");
        assertEquals(Validation.isValidationLineInput(input), expected);
    }

    @Test
    void 좌표_생성_확인() {
        String s = "(10,10)";
        assertThat(InputView.generatePoint(s)).isEqualTo(new Point(10,10));
    }

    @Test
    void 좌표_2개이상_생성() {
        String s = "(10,10)-(22,10)-(22,18)-(10,18)";
        assertThat(InputView.generatePoints(s)).isEqualTo(Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18)));

    }
}
