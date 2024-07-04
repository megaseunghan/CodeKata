package lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B21921 {
    static int[] visitors;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visitors = new int[n];

        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < visitors.length; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < visitors.length; i++) {
            sum += visitors[i];
        }

        int max = sum;
        int answer = 1;

        for (int i = 0; i < n - x; i++) {
            sum += visitors[i + x];
            sum -= visitors[i];

            if (sum == max) {
                answer++;
            }

            if (sum > max) {
                answer = 1;
                max = sum;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(answer);
        }

    }
}
