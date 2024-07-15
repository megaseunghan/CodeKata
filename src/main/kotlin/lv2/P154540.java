package lv2;

import java.util.*;

public class P154540 {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] ocean;
    boolean[][] visit;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()];
        ocean = new int[maps.length][maps[0].length()];

        // 배열 초기화
        for (int i = 0; i < maps.length; i++) {
            String[] map = maps[i].split("");

            for (int j = 0; j < map.length; j++) {
                if (map[j].equals("X")) ocean[i][j] = 999;
                else ocean[i][j] = Integer.parseInt(map[j]);
            }
        }

        // DFS
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if (!visit[i][j] && ocean[i][j] != 999) {
                    int result = DFS(i, j);
                    if (result != 0) list.add(result);
                }
            }
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];


        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public int DFS(int x, int y) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(x, y));
        int count = ocean[x][y];

        while (!stack.isEmpty()) {
            Point now = stack.pop();

            x = now.x;
            y = now.y;

            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = x + D[i][0];
                int newY = y + D[i][1];

                if (newX >= 0 && newY >= 0 && newX < ocean.length && newY < ocean[0].length) {
                    if (!visit[newX][newY] && ocean[newX][newY] != 999) {
                        visit[newX][newY] = true;
                        stack.push(new Point(newX, newY));
                        count += ocean[newX][newY];
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new P154540().solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    }
}
