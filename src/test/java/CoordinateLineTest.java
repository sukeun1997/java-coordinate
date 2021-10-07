import Coordinate.Model.*;
import Coordinate.View.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
        assertThat(InputView.generatePoints(s).stream().findFirst().get()).isEqualTo(new Point(10,10));
    }

    @Test
    void 좌표_2개이상_생성() {
        String s = "(10,10)-(22,10)-(22,18)-(10,18)";
        assertThat(InputView.generatePoints(s)).isEqualTo(Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18)));
    }

    @Test
    void FigureFactory_Line_객체_생성() {
        String s = "(10,10)-(14,15)";
        FigureFactory.create(InputView.generatePoints(s));
    }

    @Test
    void 선_길이() {
        String s = "(10,10)-(14,15)";
        Figure line = FigureFactory.create(InputView.generatePoints(s));
        assertEquals(line.area(), 6.403124, 0.001);
    }

    @Test
    void 사각형_넓이() {
        String s = "(10,10)-(22,10)-(22,18)-(10,18)";
        Figure rect = FigureFactory.create(InputView.generatePoints(s));
        assertEquals(rect.area(), 96);
    }

    @Test
    void 삼각형_생성() {
        String s = "(10,10)-(14,15)-(20,8)";
        Figure tri = FigureFactory.create(InputView.generatePoints(s));
        assertEquals(tri.getPoints(), new TRIANGLE(Arrays.asList(new Point(10,10), new Point(14,15), new Point(20,8))).getPoints());
    }

    @Test
    void 삼각형_세_변의_길이() {
        String s = "(10,10)-(14,15)-(20,8)";
        TRIANGLE tri = (TRIANGLE) FigureFactory.create(InputView.generatePoints(s));
        assertEquals(tri.ConvertToLine(tri.getPoints()),Arrays.asList(Math.sqrt(16+25),Math.sqrt(36+49), Math.sqrt(100+4)));
        System.out.println(tri.ConvertToLine(tri.getPoints()));
    }

    @Test
    void 삼각형_넓이() {
        String s = "(10,10)-(14,15)-(20,8)";
        TRIANGLE tri = (TRIANGLE) FigureFactory.create(InputView.generatePoints(s));
        assertEquals(tri.area(), 29);
    }
}
