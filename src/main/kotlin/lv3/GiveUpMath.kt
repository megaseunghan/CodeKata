package lv3

import java.util.*
import kotlin.collections.*


class GiveUpMath {
    fun solution(answers: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        var counts = arrayOf(0, 0, 0)
        val trio = arrayOf(
            listOf(1, 2, 3, 4, 5),
            listOf(2, 1, 2, 3, 2, 4, 2, 5),
            listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )

        for (i in 0..2) {
            var count = 0
            val queue = LinkedList(trio[i])

            for (cur in answers) {
                val num = queue.poll()
                if (num == cur) {
                    count++
                }
                queue.offer(num)
            }
            counts[i] = count
        }

        var max = 0
        counts.forEach { max = Math.max(max, it) }

        for (i in counts.indices) {
            if (counts[i] == max) {
                answer += (i + 1)
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    GiveUpMath().solution(intArrayOf(1, 2, 3, 4, 5))
    GiveUpMath().solution(intArrayOf(1, 3, 2, 4, 2))
}