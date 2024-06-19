package lv1;

import java.util.*;

public class P64061 {
    public int solution(int[][] board, int[] moves) {

        List<Queue<Integer>> boards = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            Queue<Integer> line = new LinkedList<>();

            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    line.add(board[j][i]);
                }
            }

            boards.add(line);
        }

        Stack<Integer> popDolls = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            Queue<Integer> queue = boards.get(moves[i] - 1);

            if (queue.peek() != null) {
                if (!popDolls.isEmpty() && queue.peek() == popDolls.peek()) {
                    popDolls.pop();
                    queue.poll();
                    answer += 2;
                    continue;
                }

                popDolls.push(queue.poll());
            }
        }
        return answer;
    }
}
