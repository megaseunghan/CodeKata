package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1916 {
    static int city;
    static int m;

    static int start;
    static int end;
    static int[] dist;
    static List<Node>[] list;
    static int INF = Integer.MAX_VALUE;
    static StringTokenizer st;

    static class Node implements Comparable<Node> {

        int target;
        int weight;

        Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        city = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[city + 1];
        list = new ArrayList[city + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= city; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(target, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[city + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int current = now.target;

            if (visit[current]) continue;
            visit[current] = true;

            for (Node adj : list[current]) {
                if (dist[adj.target] > dist[current] + adj.weight) {
                    dist[adj.target] = dist[current] + adj.weight;
                    q.add(new Node(adj.target, dist[adj.target]));
                }
            }
        }
    }
}
