package basicclass SumOfNoneNumber {    fun solution(numbers: IntArray): Int = if (numbers.sum() > 45) numbers.sum() - 45 else 45 - numbers.sum()}