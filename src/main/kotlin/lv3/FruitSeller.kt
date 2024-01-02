package lv3

class FruitSeller {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var count = 0
        var arr = mutableListOf<Int>()
        for (apple in score) {
            arr += apple
            count++

            if (count == m) {
                answer += arr[m - 1] * m
                arr = mutableListOf()
                count = 0
            }
        }

        return answer
    }
}

fun main() {
    println(FruitSeller().solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
    println(FruitSeller().solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}