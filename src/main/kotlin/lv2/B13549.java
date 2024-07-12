package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.add(new int[]{N, 0});
        boolean[] visited = new boolean[100_001];

        int count = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nPos = now[0];

            count = now[1];

            if (nPos == K) {
                break;
            }

            visited[nPos] = true;

            if (nPos * 2 <= 100_000 && !visited[nPos * 2]) {
                q.add(new int[]{nPos * 2, count});
            }
            if (nPos < K && nPos + 1 <= 100_000 && !visited[nPos + 1]) {
                q.add(new int[]{nPos + 1, count + 1});
            }
            if (nPos - 1 >= 0 && !visited[nPos - 1]) {
                q.add(new int[]{nPos - 1, count + 1});
            }
        }

        System.out.println(count);
    }
}
