package problem2

import PolishNotation
import readStringList


fun main() {
    readStringList().forEach { println(PolishNotation(it).calculate()) }
}