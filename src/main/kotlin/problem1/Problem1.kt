package problem1

import readInt
import readIntList

fun main() {
    val k = readInt()
    val a = readIntList()
    println(getPairsCount(k, a))
}

/**
 * Using hash map to fast read of values that we already pass.
 * So read value from list, do check for it's pair in hash map.
 * If there is one: we add its count (value) to result.
 * In any case: we do increase value in map with current number s key.
 */
fun getPairsCount(sum: Int, list: List<Int>): Int {
    val hashMap = HashMap<Int, Int>()
    var count = 0
    for (i in list.indices) {
        val tmp = sum - list[i]
        if (hashMap.containsKey(tmp)) {
            count += hashMap[tmp] ?: 0
        }
        hashMap[list[i]] = hashMap.getOrDefault(list[i], 0) + 1
    }
    return count
}
