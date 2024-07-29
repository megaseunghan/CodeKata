package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;


        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1];
            }
        });

        List<Integer> list = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int temp = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                temp += data[i - 1][j] % i;
            }
            list.add(temp);
        }

        answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer = answer ^ list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int solution = new P147354().solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3);
        System.out.println(solution);
    }
}
