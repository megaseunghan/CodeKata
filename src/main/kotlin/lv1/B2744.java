package lv1;

import java.util.*;

public class B2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        // 65 ~ 90 대문자
        // 97 ~ 122 소문자
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append(Character.toLowerCase(c));
            } else if (c >= 97 && c <= 122) {
                sb.append(Character.toUpperCase(c));
            }
        }

        System.out.println(sb.toString());
    }
}
