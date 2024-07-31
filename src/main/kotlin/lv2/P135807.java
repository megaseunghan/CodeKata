package lv2;

import java.math.BigInteger;
import java.util.Arrays;

public class P135807 {
    public int solution(int[] arrayA, int[] arrayB) {
        int mA = Arrays.stream(arrayA).min().getAsInt();
        int mB = Arrays.stream(arrayB).min().getAsInt();
        int max = Math.max(mA, mB);

        int answer = 0;
        for (int i = 2; i < max; i++) {
            if (isDividable(arrayA, i) && isNotDividable(arrayB, i) ||
                    isDividable(arrayB, i) && isNotDividable(arrayB, i)) {
                answer = i;
            }
        }
        return answer;
    }

    public boolean isDividable(int[] arr, int num) {
        for (int elem : arr) {
            if (elem % num == 0) continue;
            else return false;
        }
        return true;
    }

    public boolean isNotDividable(int[] arr, int num) {
        for (int elem : arr) {
            if (elem % num != 0) continue;
            else return false;
        }
        return true;
    }
}
