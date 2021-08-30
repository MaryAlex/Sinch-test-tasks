import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Problem2Test {
    @Test
    fun examples() {
        assertEquals(expected = "42.00", actual = PolishNotation("+ + 0.5 1.5 * 4 10").calculate())
        assertEquals(expected = "1337.00", actual = PolishNotation("- 2e3 - 700 + 7 * 2 15").calculate())
        assertEquals(expected = "-12.50", actual = PolishNotation("- -1.5 * 3.1415 / -7 -2").calculate())
        assertEquals(expected = "100500.00", actual = PolishNotation("100500").calculate())
        assertEquals(expected = "error", actual = PolishNotation("1 2").calculate())
        assertEquals(expected = "error", actual = PolishNotation("+ 1").calculate())
    }
}