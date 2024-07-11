package lv2;

import java.util.PriorityQueue;

public class P155651 {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[][] book_time) {
        // 시작 시간이 같으면 입실인 것부터, 시작 시간이 일찍인 것부터.
        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x));

        for (String[] time : book_time) {
            pq.add(new Point(toMin(time[0]), 1));
            pq.add(new Point(toMin(time[1]) + 10, -1));
        }

        int answer = 0, count = 0;

        while (!pq.isEmpty()) {
            Point point = pq.poll();
            count += point.y;
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public int toMin(String time) {
        String[] hm = time.split(":");
        return (Integer.parseInt((hm[0])) * 60) + Integer.parseInt(hm[1]);
    }
}


