package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16593 {
    static long start, target;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Long.parseLong(st.nextToken());
        target = Long.parseLong(st.nextToken());

        System.out.println(bfs());
        br.close();
    }

    static long bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{start, 1});

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long[] now = q.poll();

                long current = now[0];
                count = now[1];

                if (current == target) {
                    return count;
                }

                long multiply = current * 2;
                long other = current * 10 + 1;

                if (multiply <= target)
                    q.add(new long[]{multiply, count + 1});

                if (other <= target)
                    q.add(new long[]{other, count + 1});
            }
        }
        return -1;
    }
}
