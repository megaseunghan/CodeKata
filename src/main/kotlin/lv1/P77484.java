package lv1;

public class P77484 {

    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int count = 0;
        int zeroCnt = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) zeroCnt++;
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) count++;
            }
        }

        answer[0] = 7 - (zeroCnt + count);
        answer[1] = 7 - count;

        // 0의 개수와 일치값의 합이 0, 1일 때
        if (zeroCnt + count < 2) {
            answer[0] = answer[1] = 6;
        }

        // 일치값이 아무것도 없을 때
        if (answer[1] >= 7) {
            answer[1]--;
        }

        return answer;
    }
}
