package lv2;

public class P160585 {
    public int solution(String[] board) {
        int xCount = 0;
        int oCount = 0;

        String[][] map = new String[3][3];

        for (int i = 0; i < 3; i++) {
            String[] ttt = board[i].split("");
            for (int j = 0; j < 3; j++) {
                if (ttt[j].equals("X")) xCount++;
                if (ttt[j].equals("O")) oCount++;
                map[i][j] = ttt[j];
            }
        }

        // 1. O가 승리 && (O의 개수)가 (X의 개수 +1)과 같지 않을 때
        // 2. X가 승리 && (O의 개수)와 (X의 개수)가 같지 않을 때
        if (!check(map, oCount, xCount)) return 0;

        // 3. O 개수가 X 개수보다 2개 이상 많은 경우
        if (oCount >= xCount + 2) return 0;

        // 4. X 개수가 O 개수보다 많은 경우
        if (xCount > oCount) return 0;

        return 1;
    }

    boolean check(String[][] map, int oCount, int xCount) {
        int[][] lines = {
                {0, 0, 0, 1, 0, 2},
                {1, 0, 1, 1, 1, 2},
                {2, 0, 2, 1, 2, 2},
                {0, 0, 1, 0, 2, 0},
                {0, 1, 1, 1, 2, 1},
                {0, 2, 1, 2, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 2, 1, 1, 2, 0}};

        for (int i = 0; i < lines.length; i++) {
            StringBuilder sb = new StringBuilder();

            String s1 = map[lines[i][0]][lines[i][1]];
            String s2 = map[lines[i][2]][lines[i][3]];
            String s3 = map[lines[i][4]][lines[i][5]];

            sb.append(s1).append(s2).append(s3);

            if (sb.toString().equals("OOO")) {
                if (oCount - xCount != 1) return false;

            } else if (sb.toString().equals("XXX")) {
                if (oCount != xCount) return false;
            }
        }

        return true;
    }
}
