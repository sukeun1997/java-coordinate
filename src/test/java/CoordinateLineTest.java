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
}
