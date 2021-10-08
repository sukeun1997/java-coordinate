package coordinate.Model;

import coordinate.View.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {

    @Test
    void 사각형_객체_생성() {
        String s = "(10,10)-(22,10)-(22,18)-(10,18)";
        Figure rect = InputView.createPoints(s);
        assertThat(rect).isInstanceOfAny(Rectangle.class);
        assertThat(rect.getPoints().size()).isEqualTo(4);
    }
}
