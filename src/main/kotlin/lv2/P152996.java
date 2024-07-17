package lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P152996 {
    // [4, 3, 2 중심 2, 3, 4]
    // 100, 100, 180, 270, 360
    // 2:2, 2:3, 2:4, 3:4
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            double w1 = weight * 1.0; // 2:2
            double w2 = (weight * 2.0) / 3.0; // 2:3
            double w3 = (weight * 2.0) / 4.0; // 2:4
            double w4 = (weight * 3.0) / 4.0; // 3:4

            if (map.containsKey(w1)) answer += map.get(w1);
            if (map.containsKey(w2)) answer += map.get(w2);
            if (map.containsKey(w3)) answer += map.get(w3);
            if (map.containsKey(w4)) answer += map.get(w4);

            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
            // 100, 100, 180, 270, 360
        }

        return answer;
    }

    public static void main(String[] args) {
        new P152996().solution(new int[]{100, 180, 360, 100, 270});
    }
}
