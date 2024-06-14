package lv1;

public class P147355 {
    public int solution(String t, String p) {
        int answer = 0;
        Long pLong = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            Long compare = Long.parseLong(t.substring(i, i + p.length()));

            if (pLong >= compare) answer++;
        }

        return answer;
    }
}
