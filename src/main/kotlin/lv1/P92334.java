package lv1;

import java.util.*;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            countMap.put(id_list[i], 0);
            reportMap.put(id_list[i], new HashSet<String>());
        }

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String reporter = st.nextToken();
            String target = st.nextToken();

            if (reportMap.get(reporter).add(target)) {
                countMap.put(target, countMap.get(target) + 1);
            }
        }

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String reporter = st.nextToken();
            String target = st.nextToken();

            if (countMap.get(target) < k) {
                reportMap.get(reporter).remove(target);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportMap.get(id_list[i]).size();
        }

        return answer;
    }
}
