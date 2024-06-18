package lv1;

public class P72410 {
    public String solution(String new_id) {

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z-_.0-9]", "");

        // 3단계
        new_id = new_id.replaceAll("[.]+", ".");

        // 4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5단계
        new_id = new_id.length() == 0 ? "a" : new_id;

        // 6단계
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;

        // 4단계 재검증
        new_id = new_id.replaceAll("[.]$", "");

        // 7단계
        while (new_id.length() < 3) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
