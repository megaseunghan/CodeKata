package lv2;

import java.util.ArrayList;
import java.util.List;

public class P134239 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();

        // 콜라츠 추측 add
        while (k > 1) {
            list.add(k);
            if (k % 2 == 0) k = k / 2;
            else k = k * 3 + 1;
        }
        list.add(k);

        // 정적분 계산
        for (int i = 0; i < ranges.length; i++) {
            // 구간 정하기
            int start = ranges[i][0];
            int end = ranges[i][1] + list.size() - 1;

            // 구간의 시작점이 끝점보다 크면 -1로 정의
            if (start > end) {
                answer[i] = -1;
                continue;
            }

            // 누적합 구하기
            double dimension = 0;

            for (int j = start; j < end; j++) {
                dimension += (list.get(j) + list.get(j + 1)) / 2.0;
            }
            answer[i] = dimension;
        }
        return answer;
    }
}
