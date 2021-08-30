fun readInt() = readLine()!!.toInt()

fun readIntList() = readCircle(String::toInt)

fun readStringList() = readCircle(String::toString)

private fun <T> readCircle(toType: String.() -> T): List<T> {
    val input = mutableListOf<T>()
    var line = readLine()
    while (line?.isNotBlank() == true) {
        line
            .toType()
            .let { input.add(it) }
        line = readLine()
    }
    return input.toList()
}
