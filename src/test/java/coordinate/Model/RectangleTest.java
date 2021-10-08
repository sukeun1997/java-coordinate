package coordinate.Model;

import coordinate.View.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {

    String s = "(10,10)-(22,10)-(22,18)-(10,18)";
    Figure rect = InputView.createPoints(s);
    Rectangle rectangle = (Rectangle) rect;

    @Test
    void 사각형_객체_생성() {
        assertThat(rect).isInstanceOfAny(Rectangle.class);
        assertThat(rect.getPoints().size()).isEqualTo(4);
    }

    @Test
    void 사각형_x_좌표_SET_만들기() {
        assertThat(rectangle.ConvertToLineX(rect.getPoints())).isEqualTo(Arrays.asList(10,22));
        System.out.println(rectangle.ConvertToLineX(rectangle.getPoints()));
    }
    @Test
    void 사각형_y_좌표_SET_만들기() {
        assertThat(rectangle.ConvertToLineY(rect.getPoints())).isEqualTo(Arrays.asList(10,18));
        System.out.println(rectangle.ConvertToLineY(rectangle.getPoints()));
    }

    @Test
    void 사각형_가로길이_구하기() {
        assertThat(rectangle.getHorizontal(rectangle.ConvertToLineX(rectangle.getPoints()))).isEqualTo(12);
    }
    @Test
    void 사각형_세로길이_구하기() {
        assertThat(rectangle.getVertical(rectangle.ConvertToLineY(rectangle.getPoints()))).isEqualTo(8);
    }

    @Test
    void 사각형_넓이(){
        assertThat(rect.area()).isEqualTo(96);
    }

        @Test
    void 사각형_검증() {
        Rectangle rectangle = (Rectangle) rect;
        assertThatCode(() -> rectangle.isRectangle(rectangle.getPoints())).doesNotThrowAnyException();
    }
}
