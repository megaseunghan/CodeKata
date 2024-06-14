package lv1;

import java.util.*;

public class P142086 {
    public int[] solution(String s) {

        Map<Character, Integer> index = new HashMap<>();

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            answer[i] = i - index.getOrDefault(c, i + 1);

            index.put(c, i);
        }
        return answer;
    }
}
