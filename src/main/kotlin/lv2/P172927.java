package lv2;

import java.util.*;

public class P172927 {
    class Mineral {
        int diamond;
        int iron;
        int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] pirodo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<Mineral> list = new ArrayList<>();
        int dias = picks[0];
        int irons = picks[1];
        int stones = picks[2];

        int total = dias + irons + stones;

        for (int i = 0; i < minerals.length; i += 5) {
            if (total == 0) break;

            int dia = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;

                int index = minerals[j].equals("diamond") ? 0 : minerals[j].equals("iron") ? 1 : 2;

                dia += pirodo[0][index];
                iron += pirodo[1][index];
                stone += pirodo[2][index];
            }
            list.add(new Mineral(dia, iron, stone));
            total--;
        }

        Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));

        for (Mineral m : list) {

            if (picks[0] > 0) {
                answer += m.diamond;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                answer += m.iron;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += m.stone;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }
}
