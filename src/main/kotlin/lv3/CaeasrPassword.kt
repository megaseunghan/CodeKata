package lv3

class CaeasrPassword {
    fun solution(s: String, n: Int): String {
        // 97 ~122
        // 65 ~ 90
        val answer = StringBuilder()

        fun nextCode(char: Char, range: IntRange): Char {
            val first = range.first
            val last = range.last

            return if (char.code > last) {
                (first + (char.code - last) - 1).toChar()
            } else {
                char
            }
        }
        s.forEach {
            if (it.isUpperCase()) {
                answer.append(nextCode(it + n, 65..90))
            }
            if (it.isLowerCase()) {
                answer.append(nextCode(it + n, 97..122))
            }
            if (it.isWhitespace()) {
                answer.append(it)
            }
        }
        return answer.toString()
    }
}

fun main() {
    println(CaeasrPassword().solution("AB", 1))
    println(CaeasrPassword().solution("z", 1))
    println(CaeasrPassword().solution("a B z", 4))
}