package coordinate.Model;

import coordinate.View.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    String s = "(10,10)-(14,15)-(20,8)";
    Figure tri = InputView.createPoints(s);

    @Test
    void 삼각형_객체_생성() {
        assertThat(tri).isInstanceOfAny(Triangle.class);
    }

    @Test
    void 삼각형_변의_길이_a() {
        Triangle triangle = (Triangle) tri;
        assertThat(triangle.ConvertToLine(tri.getPoints())).containsAll(Arrays.asList(Math.sqrt(16 + 25), Math.sqrt(100 + 4), Math.sqrt(36 + 49)));
    }

    @Test
    void 삼각형_넓이() {
        Triangle triangle = (Triangle) tri;

        assertThat(triangle.area()).isEqualTo(29);
    }
}
