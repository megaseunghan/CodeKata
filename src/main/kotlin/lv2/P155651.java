package lv2;

public class P155651 {

    public int solution(String[][] book_time) {
        int answer = 0;
        int maxTime = 24 * 60 + 10; // 1450
        int cleanTime = 10;

        int[] rooms = new int[maxTime];

        for (String[] time : book_time) {
            String in = time[0];
            String out = time[1];

            rooms[calTime(in)] += 1;
            rooms[calTime(out) + cleanTime] += -1;
        }

        // 누적합
        for (int i = 1; i < maxTime; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    private static int calTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return ((Integer.parseInt(hour) * 60) + Integer.parseInt(minute));
    }
}
