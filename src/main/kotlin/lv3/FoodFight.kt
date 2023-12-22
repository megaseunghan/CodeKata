package lv3

class FoodFight {
    fun solution(food: IntArray): String {
        var answer = StringBuilder()

        for (i in 1 until food.size) {
            val count = food[i] / 2
            answer.append(i.toString().repeat(count))
        }
        val other = answer.toString().reversed()
        answer.append(0)
        answer.append(other)

        return answer.toString()
    }
}