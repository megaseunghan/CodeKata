package lv3

import kotlin.math.max

class MinSquare {
    fun solution(sizes: Array<IntArray>): Int {
        var width = 0
        var height = 0

        sizes.forEach {
            if (it[0] < it[1]) {
                var temp = it[1]
                it[1] = it[0]
                it[0] = temp
            }

            width = max(it[0], width)
            height = max(it[1], height)
        }

        return width * height
    }
}