enum class MathOperator(val represented: String, val evaluate: (Double, Double) -> Double) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        val REPRESENTED_MAP = values().associateBy { it.represented }

        val String.isOperator get() = REPRESENTED_MAP[this] != null
    }
}