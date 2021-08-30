import problem1.getPairsCount
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem1Test {
    @Test
    fun example() {
        assertEquals(expected = 2, actual = getPairsCount(6, listOf(2, 1, 4, 5, 3)))
    }

    @Test
    fun negative() {
        assertEquals(expected = 3, actual = getPairsCount(6, listOf(1, 5, 11, 7, -1, -5)))
    }

    @Test
    fun none() {
        assertEquals(expected = 0, actual = getPairsCount(6, listOf(2, 1, 1, 1, 1)))
    }

    @Test
    fun wrongDuplicate() {
        assertEquals(expected = 1, actual = getPairsCount(6, listOf(4, 1, 4, 5, 3)))
    }

    @Test
    fun duplicate() {
        assertEquals(expected = 2, actual = getPairsCount(6, listOf(1, 1, 4, 5, 3)))
    }

    @Test
    fun big() {
        assertEquals(expected = 2, actual = getPairsCount(6, listOf(1, 1, 4, 5, 3) + List(10e6.toInt()) { 4 }))
    }
}