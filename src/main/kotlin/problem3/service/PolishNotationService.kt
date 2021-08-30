package problem3.service

import PolishNotation

fun calculatePolishNotation(expressions: String) =
    if (expressions.isNotBlank()) {
        expressions
            .split(NEW_LINE_SYMBOL)
            .joinToString(separator = NEW_LINE_SYMBOL) { PolishNotation(it).calculate() }
    } else "Body with polish notations required."

private const val NEW_LINE_SYMBOL = "\n"
