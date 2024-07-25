package lv2;

public class P150369 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        int d = 0;
        int p = 0;
        for (int i = n - 1; i >= 0; i--) {
            d -= deliveries[i];
            p -= pickups[i];

            while (d < 0 || p < 0) {
                d += cap;
                p += cap;
                answer += (i + 1) * 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] deliveries = new int[]{1, 0, 3, 1, 2};
        int[] pickup = new int[]{0, 3, 0, 4, 0};
        new P150369().solution(4, 5, deliveries, pickup);
    }
}
