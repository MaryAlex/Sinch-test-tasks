import MathOperator.Companion.REPRESENTED_MAP
import MathOperator.Companion.isOperator

class PolishNotation(expressionsLine: String) {
    private var answer = ""
    private val expressions = expressionsLine.split(SPACE)
    private var pendingOperand = false
    private val operatorStack = ArrayDeque<MathOperator>()
    private val numberStack = ArrayDeque<Double>()

    fun calculate(): String {
        if (expressions.size < MAX_EXPRESSIONS_COUNT) {
            expressions.forEach { expressionHandle(it) }
            updateAnswer()
        } else updateForExceptionAnswer()
        return answer
    }

    private fun updateAnswer() {
        if (operatorStack.isNotEmpty()) updateForExceptionAnswer()
        else {
            answer = numberStack
                .removeFirstOrNull()
                ?.let { ANSWER_FORMAT.format(it) }
                ?: ANSWER_FOR_EXCEPTION
        }
    }

    private fun expressionHandle(expression: String) {
        if (expression.isOperator) {
            operatorStack.addFirst(REPRESENTED_MAP[expression]!!)
            pendingOperand = false
        } else if (expression.toDoubleOrNull() != null) {
            var currentNumber = expression.toDouble()
            if (pendingOperand) {
                while (numberStack.isNotEmpty()) {
                    val numberFromStack = numberStack.removeFirstOrNull() ?: return updateForExceptionAnswer()
                    val currentOperator = operatorStack.removeFirstOrNull() ?: return updateForExceptionAnswer()
                    currentNumber = currentOperator.evaluate(numberFromStack, currentNumber)
                }
            }
            numberStack.addFirst(currentNumber)
            pendingOperand = true
        } else return updateForExceptionAnswer()
    }

    private fun updateForExceptionAnswer() {
        answer = ANSWER_FOR_EXCEPTION
    }

    companion object {
        private const val SPACE = ' '
        private const val MAX_EXPRESSIONS_COUNT = 100_000
        private const val DIGITS_IN_ANSWER = 2
        private const val ANSWER_FORMAT = "%.${DIGITS_IN_ANSWER}f"
        private const val ANSWER_FOR_EXCEPTION = "error"
    }
}