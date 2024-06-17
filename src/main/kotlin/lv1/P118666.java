package lv1;

import java.util.HashMap;
import java.util.Map;

public class P118666 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] types = {"RT", "CF", "JM", "AN"};

        for (int i = 0; i < types.length; i++) {
            String t1 = String.valueOf(types[i].charAt(0));
            String t2 = String.valueOf(types[i].charAt(1));

            map.put(t1, 0);
            map.put(t2, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            String left = survey[i].split("")[0];
            String right = survey[i].split("")[1];

            if (choice == 4) continue;

            if (choice < 4) {
                map.put(left, map.get(left) + (4 - choice));
            } else {
                map.put(right, map.get(right) + (choice - 4));
            }
        }

        for (int i = 0; i < 4; i++) {
            String t1 = String.valueOf(types[i].charAt(0));
            String t2 = String.valueOf(types[i].charAt(1));

            if (map.get(t1) >= map.get(t2)) {
                answer.append(t1);
            } else {
                answer.append(t2);
            }
        }
        return answer.toString();
    }
}
