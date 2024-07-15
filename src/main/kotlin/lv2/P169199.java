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
    int[][] map;

    Pointer start;
    Pointer goal;

    public int solution(String[] board) {
        map = new int[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {

            String[] split = board[i].split("");

            for (int j = 0; j < split.length; j++) {

                String s = split[j];

                if (s.equals("G")) goal = new Pointer(i, j);
                if (s.equals("R")) start = new Pointer(i, j);
                if (s.equals("D")) map[i][j] = -1;
                else map[i][j] = Integer.MAX_VALUE;
            }
        }

        BFS(start.x, start.y);
        if (map[goal.x][goal.y] == Integer.MAX_VALUE) return -1;

        return map[goal.x][goal.y];
    }

    void BFS(int x, int y) {
        map[x][y] = 0;

        Queue<Pointer> q = new LinkedList<>();
        q.add(new Pointer(x, y));

        while(!q.isEmpty()) {
            Pointer now = q.poll();
            int curX = now.x;
            int curY = now.y;

            for (int i = 0; i < 4; i++) {
                int nX = curX + D[i][0];
                int nY = curY + D[i][1];

                while(validation(nX, nY) && map[nX][nY] != -1) {
                    nX += D[i][0];
                    nY += D[i][1];
                }
                nX -= D[i][0];
                nY -= D[i][1];

                if (nX == curX && nY == curY) continue;
                if (map[nX][nY] <= map[curX][curY] + 1) continue;

                map[nX][nY] = map[curX][curY] + 1;
                q.add(new Pointer(nX, nY));
            }
        }
    }

    public boolean validation(int nx, int ny){
        if (0 <= nx && 0 <= ny && nx < map.length && ny < map[0].length) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P169199().solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(new P169199().solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }
}
