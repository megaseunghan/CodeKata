package lv3

class PickTwoAndSum {
    fun solution(numbers: IntArray): IntArray {
        val answer = hashSetOf<Int>()
        numbers.forEachIndexed { indexI, i ->
            numbers.forEachIndexed { indexJ, j ->
                if (indexI != indexJ) {
                    answer += i + j
                }
            }
        }
        return answer.sorted().toIntArray()
    }
}