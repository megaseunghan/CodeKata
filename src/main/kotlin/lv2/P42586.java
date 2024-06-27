package lv2;

import java.util.*;

public class P42586 {
    // progress 93, 30, 55
    // speeds 1, 30, 5
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = 0;

            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }

            q.add(day);
        }

        while (!q.isEmpty()) {
            int previous = q.poll();
            int count = 1;
            while (!q.isEmpty() && previous >= q.peek()) {
                count++;
                q.poll();
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answer = new P42586().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
