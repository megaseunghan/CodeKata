package lv1;

public class P250125 {
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row;
    int col;

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        String color = board[h][w];

        for (int i = 0; i < deltas.length; i++) {
            row = h + deltas[i][0];
            col = w + deltas[i][1];

            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {

                if (board[row][col].equals(color)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
