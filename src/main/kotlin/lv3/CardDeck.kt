package lv3

class CardDeck {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {

        var answer = arrayOf<String>()
        var max = cards1.size + cards2.size
        var cards1 = cards1
        var cards2 = cards2
        var tempGoal = goal

        while (true) {
            if (max == 0) break;
            if (answer.contentEquals(goal)) break

            if (cards1.indexOf(tempGoal[0]) == 0) {
                answer += cards1[0]
                cards1 = cards1.sliceArray(1 until cards1.size)
                tempGoal = tempGoal.sliceArray(1 until tempGoal.size)
                continue
            } else if (cards2.indexOf(tempGoal[0]) == 0) {
                answer += cards2[0]
                cards2 = cards2.sliceArray(1 until cards2.size)
                tempGoal = tempGoal.sliceArray(1 until tempGoal.size)
                continue
            }
            max--
        }

        return if (answer.contentEquals(goal)) "Yes" else "No"
    }
}
