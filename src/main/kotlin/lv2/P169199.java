package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class P169199 {
    // R 시작
    // D 장애물
    // G 목표
    class Pointer {
        int x;
        int y;

        Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] D = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Pointer start;
    Pointer goal;

    int[][] map;
    boolean[][] visited;

    public int solution(String[] board) {
        map = new int[board.length][board[0].split("").length];

        for (int i = 0; i < board.length; i++) {

            String[] split = board[i].split("");

            for (int j = 0; j < split.length; j++) {

                String s = split[j];

                if (s.equals("D")) {
                    map[i][j] = -1;
                    continue;
                }

                if (s.equals("G")) {
                    goal = new Pointer(i, j);
                } else if (s.equals("R")) {
                    start = new Pointer(i, j);
                }
            }
        }


        int answer = BFS(start.x, start.y);

        return answer;
    }

    int BFS(int x, int y) {
        int count = 0;
        Queue<Pointer> queue = new LinkedList<>();
        queue.offer(new Pointer(x, y));

        while (!queue.isEmpty()) {

            Pointer cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                count = map[cur.x][cur.y];

                int newX = cur.x;
                int newY = cur.y;


                while (true) {
                    newX += D[i][0];
                    newY += D[i][1];

                    if ((newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) || (map[newX][newY] == -1)) {
                        break;
                    }
                }

                newX -= D[i][0];
                newY -= D[i][1];

                if (map[newX][newY] != 0) {
                    continue;
                }

                queue.offer(new Pointer(newX, newY));
                map[newX][newY] = count + 1;

                if (newX == goal.x && newY == goal.y) {
                    return count;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P169199().solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(new P169199().solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }
}
