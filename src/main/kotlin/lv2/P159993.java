package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class P159993 {
    class Pointer {
        int row;
        int col;

        Pointer(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] distance;
    int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Pointer start, end, lever;

    public int solution(String[] maps) {
        distance = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String[] row = maps[i].split("");

            for (int j = 0; j < row.length; j++) {
                if (row[j].equals("S")) {
                    start = new Pointer(i, j);
                }
                if (row[j].equals("E")) {
                    end = new Pointer(i, j);
                }
                if (row[j].equals("L")) {
                    lever = new Pointer(i, j);
                }
                if (row[j].equals("X")) {
                    distance[i][j] = 999;
                }
            }
        }

        BFS(start.row, start.col, "lever");
        if (distance[lever.row][lever.col] == 0) {
            return -1;
        } else {
            BFS(lever.row, lever.col, "exit");
        }

        int answer = distance[end.row][end.col] != 0 ? distance[end.row][end.col] : -1;
        return answer;
    }

    public void BFS(int row, int col, String find) {
        Queue<Pointer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[distance.length][distance[0].length];
        queue.add(new Pointer(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Pointer now = queue.poll();

            if (find.equals("lever") && now.row == lever.row && now.col == lever.col) break;
            if (find.equals("exit") && now.row == end.row && now.col == end.col) break;

            for (int i = 0; i < 4; i++) {
                int nRow = now.row + delta[i][0];
                int nCol = now.col + delta[i][1];

                if (nRow >= 0 && nRow < distance.length && nCol >= 0 && nCol < distance[0].length) {
                    if (distance[nRow][nCol] != 999 && !visited[nRow][nCol]) {
                        distance[nRow][nCol] = distance[now.row][now.col] + 1;
                        visited[nRow][nCol] = true;
                        queue.add(new Pointer(nRow, nCol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P159993().solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }
}
