package lv1;

import java.util.Stack;

public class P12906 {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty() || i != stack.peek()) {
                stack.push(i);
            }

            if (!stack.isEmpty() && i == stack.peek()) {
                continue;
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
