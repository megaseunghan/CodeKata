package lv3

import java.util.PriorityQueue

class HallOfFame {
    fun solution(k: Int, score: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val pq = PriorityQueue<Int>()

        score.forEach {
            if (pq.size < k) {
                pq += it
            } else {
                if (pq.peek() < it) {
                    pq.add(it)
                    pq.poll()
                }
            }
            answer += pq.peek()
        }
        return answer.toIntArray()
    }
}

fun main() {
    println(HallOfFame().solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).contentToString())
}