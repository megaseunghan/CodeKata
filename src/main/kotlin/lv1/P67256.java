package lv1;

import java.util.LinkedList;
import java.util.Queue;

public class P67256 {
    String[][] keypad;
    StringBuilder answer;
    int row, col;
    int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public String solution(int[] numbers, String hand) {
        answer = new StringBuilder();
        keypad = new String[4][3];

        int num = 1;
        keypad[3][0] = "*";
        keypad[3][1] = "0";
        keypad[3][2] = "#";

        for (int i = 0; i < keypad.length - 1; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                keypad[i][j] = String.valueOf(num);
                num++;
            }
        }

        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number == 1 || number == 4 || number == 7) {
                left[1] = 0;
                if (number == 1) {
                    left[0] = 0;
                } else if (number == 4) {
                    left[0] = 1;
                } else {
                    left[0] = 2;
                }
                answer.append("L");
            }

            if (number == 2 || number == 5 || number == 8 || number == 0) {
                int lDis = bfs(left, number);
                int rDis = bfs(right, number);

                if (lDis > rDis) {
                    right[0] = number == 2 ? 0 : number == 5 ? 1 : number == 8 ? 2 : number == 0 ? 3 : -1;
                    right[1] = 1;
                    answer.append("R");
                } else if (lDis == rDis) {
                    if (hand.equals("left")) {
                        left[0] = number == 2 ? 0 : number == 5 ? 1 : number == 8 ? 2 : number == 0 ? 3 : -1;
                        left[1] = 1;
                        answer.append("L");
                    } else {
                        right[0] = number == 2 ? 0 : number == 5 ? 1 : number == 8 ? 2 : number == 0 ? 3 : -1;
                        right[1] = 1;
                        answer.append("R");
                    }
                } else {
                    left[0] = number == 2 ? 0 : number == 5 ? 1 : number == 8 ? 2 : number == 0 ? 3 : -1;
                    left[1] = 1;
                    answer.append("L");
                }
            }

            if (number == 3 || number == 6 || number == 9) {
                right[1] = 2;
                if (number == 3) {
                    right[0] = 0;
                } else if (number == 6) {
                    right[0] = 1;
                } else {
                    right[0] = 2;
                }
                answer.append("R");
            }
        }

        return answer.toString();
    }

    int bfs(int[] start, int target) {
        if (keypad[start[0]][start[1]].equals(String.valueOf(target))) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();

            while (size-- > 0) {
                int[] rc = queue.poll();
                row = rc[0];
                col = rc[1];

                for (int i = 0; i < 4; i++) {
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];

                    if (newRow >= 0 && newRow < keypad.length && newCol >= 0 && newCol < keypad[0].length) {
                        if (keypad[newRow][newCol].equals(String.valueOf(target))) {
                            return distance;
                        }
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return distance;
    }
}
