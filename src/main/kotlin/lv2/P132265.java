package lv2;

import java.util.*;

public class P132265 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> older = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();

        for (int t : topping) {
            older.put(t, older.getOrDefault(t, 0) + 1);
        }

        for (int i = topping.length - 1; i >= 0; i--) {
            younger.put(topping[i], younger.getOrDefault(topping[i], 0) + 1);
            older.put(topping[i], older.getOrDefault(topping[i], 0) - 1);
            if (older.get(topping[i]) == 0) older.remove(topping[i]);
            if (younger.size() == older.size()) answer++;
            if (younger.size() > older.size()) break;
        }
        return answer;
    }
}
