package lv2;

import java.util.*;

public class P131704 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 1; i < order.length + 1; i++) {
            if (order[answer] == i) {
                answer++;
            } else {
                stack.push(i);
                idx++;
            }

            while (idx != 0) {
                if (order[answer] == stack.peek()) {
                    stack.pop();
                    answer++;
                    idx--;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
