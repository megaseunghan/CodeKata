package lv1;

import java.util.*;

public class P42889 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int challengers = stages.length;

        Map<Integer, Double> fail = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }

            if (count == 0) {
                fail.put(i, (double) 0);
            } else {
                fail.put(i, (double) count / challengers);
            }
            challengers -= count;
        }

        List<Integer> list = new ArrayList<>(fail.keySet());

        Collections.sort(list, (o1, o2) -> Double.compare(fail.get(o2), fail.get(o1)));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}
