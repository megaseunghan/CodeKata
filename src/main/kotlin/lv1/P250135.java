package lv1;

public class P250135 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        //0시~주어진시간까지 횟수를 구한 이후 빼면 됨
        int answer = getCntFromDegree(h2, m2, s2) - getCntFromDegree(h1, m1, s1);

        //0시와 12시인경우에만 예외적으로 1씩 더해줌
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) answer += 1;

        return answer;
    }

    private int getCntFromDegree(int h, int m, int s) {
        double hDg = (1d * h * 30 + m * 0.5 + s * 0.5 / 60) % 360;
        double mDg = (1d * m * 6 + s * 0.1) % 360;
        double sDg = s * 6;

        // 0시0분0초는 분에 한번이므로 -1로 시작
        int count = -1;

        // 마지막 분의 상태를 계산
        if (sDg >= mDg) count += 1;
        if (sDg >= hDg) count += 1;

        //분당 2번씩 만난다고 계산
        count += (h * 60 + m) * 2;
        //59분 -> 0분일때는 분침과 만나지 않음
        count -= h;
        // 11시59분59초 -> 12시인경우 분,초침과 만나지않고 12시에 2번이아닌 1번만 만나는걸로 처리
        if (h >= 12) count -= 2;
        return count;
    }
}
