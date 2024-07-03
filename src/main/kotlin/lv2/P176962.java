package lv2;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class P176962 {
    class Subject implements Comparable<Subject> {
        String name;
        int start;
        int leftTime;

        Subject(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.leftTime = playtime;
        }

        @Override
        public int compareTo(@NotNull Subject o) {
            return this.start - o.start;
        }
    }

    public String[] solution(String[][] plans) {
        List<Subject> list = new ArrayList<>();
        Queue<String> finish = new LinkedList<>();
        Stack<Subject> process = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            int time = calculate(plans[i][1]);
            list.add(new Subject(plans[i][0], time, Integer.parseInt(plans[i][2])));
        }

        Collections.sort(list);

        int time = 0;

        for (int i = 0; i < list.size(); i++) {
            Subject now = list.get(i);

            int left = now.start - time; // 730 - 700 = 30

            while (!process.isEmpty() && left > 0) {
                Subject temp = process.pop();

                if (temp.leftTime >= left) {
                    temp.leftTime -= left;
                    left = 0;


                    if (temp.leftTime != 0) { // 시간을 다 빼도 아직 시간이 남아있을 때
                        process.push(temp);
                        continue;
                    }

                    finish.add(temp.name);

                } else { // 작업이  끝났을 때
                    left -= temp.leftTime;
                    finish.add(temp.name);
                }
            }
            process.push(now);
            time = now.start;
        }

        String[] answer = new String[list.size()];

        int idx = 0;

        while (!finish.isEmpty()) {
            answer[idx++] = finish.poll();
        }

        while (!process.isEmpty()) {
            answer[idx++] = process.pop().name;
        }

        return answer;
    }

    // 분 단위로 변경
    private static int calculate(String start) {
        String[] arr = start.split(":");
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }
}
