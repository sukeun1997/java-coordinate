package coordinate.Model;

import coordinate.View.InputView;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void Line_객체_생성() {
        String s = "(10,10)-(14,15)";
        Line line = new Line(InputView.createPoints(s));
        assertThat(line).isEqualTo(new Line(Arrays.asList(Point.of(10, 10), Point.of(14, 15))));
    }

    @Test
    void Line_객체_유효성_검사() {
        String s = "(10,10)-(14,15)-(10,10)";
        assertThatThrownBy(() -> new Line(InputView.createPoints(s))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("선");
    }

}
