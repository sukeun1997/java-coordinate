package coordinate.Model;

import coordinate.View.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {

    @Test
    void 삼각형_객체_생성() {
        String s = "(10,10)-(14,15)-(20,8)";
        Figure tri = InputView.createPoints(s);
        assertThat(tri).isInstanceOfAny(Triangle.class);
    }
}
