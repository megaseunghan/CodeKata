package lv1;

public class P161989 {
    public int solution(int n, int m, int[] section) {
        // # 규칙
        // * 롤러는 벽에서 벗어나면 안됨
        // * 구역의 일부분만 포함되도록 칠하면 안됨

        // # 리턴값
        // 섹션을 롤러로 칠해야 하는 최소 횟수
        int answer = 0;
        int temp = 0;
        for (int s : section) {
            if (s > temp) {
                answer++;
                temp = m + s - 1;
            }
        }
        return answer;
    }
}
