package lv3

class NumberStringAndEngWords {
    fun solution(s: String): Int {
        var stackString = StringBuilder()
        val answer = StringBuilder()

        s.forEach {
            if (engNumber.keys.contains(stackString.toString())) {
                answer.append(engNumber[stackString.toString()])
                stackString = StringBuilder()
            }

            it.digitToIntOrNull()?.let { num -> answer.append(num) }
                ?: stackString.append(it)
        }
        if (stackString.isNotEmpty()) {
            answer.append(engNumber[stackString.toString()])
        }
        return answer.toString().toInt()
    }

    companion object {
        val engNumber = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )
    }
}
