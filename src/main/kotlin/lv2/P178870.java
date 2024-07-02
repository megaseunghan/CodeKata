package lv2;

import java.util.*;

public class P178870 {
    class Pointer {
        int left;
        int right;
        int length;

        Pointer(int left, int right) {
            this.left = left;
            this.right = right;
            this.length = right - left;
        }
    }

    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[left];
        int n = sequence.length;

        List<Pointer> list = new ArrayList<>();

        while (true) {
            if (sum == k) {
                list.add(new Pointer(left, right));
            }

            if (left == n && right == n) break;

            // 우측 포인터 ++
            if (sum <= k && right < n) {
                right++;
                if (right < n) sum += sequence[right];
                // 좌측 포인터 ++
            } else {
                if (left < n) sum -= sequence[left];
                left++;
            }
        }

        list.sort(new Comparator<Pointer>() {
            @Override
            public int compare(Pointer o1, Pointer o2) {
                if (o1.length == o2.length) {
                    return o1.left - o2.left;
                }
                return o1.length - o2.length;
            }
        });

        return new int[]{list.get(0).left, list.get(0).right};
    }
}
