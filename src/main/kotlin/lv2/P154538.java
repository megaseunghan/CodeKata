package lv2;

import java.util.*;

public class P154538 {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        q.offer(x);
        visit.add(x);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == y) return answer;
                if (now + n <= y && !visit.contains(now + n)) {
                    q.offer(now + n);
                    visit.add(now + n);
                }
                if (now * 3 <= y && !visit.contains(now * 3)) {
                    q.offer(now * 3);
                    visit.add(now * 3);
                }
                if (now * 2 <= y && !visit.contains(now * 2)) {
                    q.offer(now * 2);
                    visit.add(now * 2);
                }
            }
            answer++;
        }
        return -1;
    }
}
