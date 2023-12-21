package lv3

class NumOfK {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        commands.map {
            val (i, j, k) = it
            answer += array.slice(i - 1 until j).sorted()[k - 1]
        }
        return answer
    }
}