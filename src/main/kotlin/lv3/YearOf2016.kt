package lv3

import java.time.LocalDate

class YearOf2016 {
    fun solution(a: Int, b: Int): String {
        val date = LocalDate.of(2016, a, b)
            .dayOfWeek
            .name
        return date.substring(0, 3)
    }
}
