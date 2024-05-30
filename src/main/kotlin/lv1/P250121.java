package lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P250121 {

    int idx;
    int sortIdx;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]

        String[] idxArr = {"code", "date", "maximum", "remain"};

        for (int i = 0; i < idxArr.length; i++) {
            if (idxArr[i].equals(ext)) {
                idx = i;
            }

            if (idxArr[i].equals(sort_by)) {
                sortIdx = i;
            }
        }

        List<int[]> arr = Arrays.stream(data)
                .filter(e -> e[idx] < val_ext)
                .collect(Collectors.toList());

        arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortIdx] - o2[sortIdx];
            }
        });

        return arr.toArray(new int[arr.size()][]);
    }

}