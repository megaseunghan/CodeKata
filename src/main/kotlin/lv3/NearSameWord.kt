package lv3

class NearSameWord {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        val indexMap = hashMapOf<Char, Int>()
        s.mapIndexed { idx, c ->
            if (indexMap.isNotEmpty() && indexMap.contains(c)) {
                println(indexMap.toList().toString())
                answer += idx - indexMap[c]!!
                indexMap[c] = idx - indexMap[c]!!
            } else {
                indexMap[c] = idx
                answer += -1
            }
        }
        return answer
    }
}