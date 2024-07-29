package lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class P142085 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k == 0) break;

            pq.offer(enemy[i]);

            if (n < enemy[i]) {
                n += pq.poll();
                k--;
            }

            n -= enemy[i];
            answer++;
        }

        return answer;
    }
}
