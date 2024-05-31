package lv1;

import java.util.*;

public class P176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> score = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int num = 0;

            for (int j = 0; j < photo[i].length; j++) {
                if (score.containsKey(photo[i][j])) {
                    num += score.get(photo[i][j]);
                }
            }

            answer.add(num);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

