package lv3

class SortStringMyOwnWay {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        strings.sortWith(Comparator { o1, o2 ->
            if (o1[n].compareTo(o2[n]) == 0) {
                o1.compareTo(o2)
            } else {
                o1[n].compareTo(o2[n])
            }
        })
        return strings
    }

//    fun solution(strings: Array<String>, n: Int): Array<String> {
//        return strings.also {
//            it.sort()
//            it.sortBy { it[n] }
//        }
//    }
}