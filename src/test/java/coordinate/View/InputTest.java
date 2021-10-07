package coordinate.View;

import coordinate.Model.Point;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    void 좌표_생성() {
        String s = "(10,10)";
        assertThat(InputView.createPoints(s)).isEqualTo(new Point(10, 10));
    }

    @ParameterizedTest
    @CsvSource(value = "[10,10]:false, (10,10):true,(10.10):false,(-1,-5):false", delimiter = ':')
    void 좌표_유효성_검사(String input , boolean expected) {
        boolean test = InputView.createPoints(input) == null ? false : true;
        assertEquals(test, expected);
    }
}
