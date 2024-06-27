package lv2;

import java.util.Stack;

public class PracticeDFS {
    // Delta 상하좌우
    int[][] delta = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void dfs(int start, int end) {
        Stack<Point> stack = new Stack<>();

        stack.push(new Point(start, end));

        while (!stack.isEmpty()) {

            Point now = stack.pop();

            for (int i = 0; i < 4; i++) {

                Point newP = new Point(now.x + delta[i][0], now.y + delta[i][1]);

                if (newP.x == 1 && newP.y == 2) {
                    return;
                }

                stack.push(new Point(newP.x, newP.y));
            }
        }
    }
}
