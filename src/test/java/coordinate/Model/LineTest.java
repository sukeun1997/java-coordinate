package coordinate.Model;

import coordinate.View.InputView;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    static Line line;
    static String s;

    @BeforeEach
    void setUp() {
        s = "(10,10)-(14,15)";
        line = new Line(InputView.createPoints(s));
    }

    @Test
    void Line_객체_생성() {
        assertThat(line).isEqualTo(new Line(Arrays.asList(Point.of(10, 10), Point.of(14, 15))));
    }

    @Test
    void Line_객체_유효성_검사() {
         s = "(10,10)-(14,15)-(10,10)";
        assertThatThrownBy(() -> new Line(InputView.createPoints(s))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("선");
    }

    @Test
    void Line_거리() {
        assertEquals(line.area(), 6.403124, 0.001);
    }

    @Test
    void Line_거리_출력() {
        assertThat(line.areaInfo()).contains("두 점 사이 거리는 6.403124");
    }
}
