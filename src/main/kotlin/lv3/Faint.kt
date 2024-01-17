package lv3

class Faint {
    fun solution(n: Int, m: Int, selection: IntArray): Int {
        var answer = 0
        var max = 0
        selection.forEach {
            if (it > max) {
                answer++
                max = it + m - 1
            }
        }
        return answer
    }
}