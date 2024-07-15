package lv2;

import java.util.*;

public class P154539 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        new P154539().solution(new int[]{9, 1, 5, 3, 6, 2});
    }
}
