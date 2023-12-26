package lv3

class Cola {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer = 0
        var n = n

        while (n >= a) {
            answer += (n / a) * b
            n = ((n / a) * b) + (n % a)

        }

        return answer
    }
}

fun main() {
    println(Cola().solution(2, 1, 20))
    println(Cola().solution(3, 1, 20))
}
