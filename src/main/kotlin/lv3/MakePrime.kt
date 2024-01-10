package lv3

class MakePrime {
    var answer = 0

    fun solution(nums: IntArray): Int {
        var visited = BooleanArray(nums.size)
        combination(nums, visited, 0, nums.size, 3)

        return answer
    }

    fun combination(nums: IntArray, visited: BooleanArray, start: Int, n: Int, r: Int) {
        if (r == 0) {
            answer += getPrime(nums, visited, n)
            return
        }

        for (i in start until n) {
            visited[i] = true
            combination(nums, visited, i + 1, n, r - 1)
            visited[i] = false
        }
    }

    private fun getPrime(nums: IntArray, visited: BooleanArray, n: Int): Int {
        var num = 0
        for (i in 0 until n) {
            if (visited[i]) {
                num += nums[i]
            }
        }
        return if (isPrime(num)) 1 else 0
    }

    private fun isPrime(num: Int): Boolean {
        for (i in 2..(Math.sqrt(num.toDouble()) + 1).toInt()) {
            if (num % i == 0) return false;
        }
        return true
    }
}