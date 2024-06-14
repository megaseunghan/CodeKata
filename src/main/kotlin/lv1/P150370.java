package lv1;

import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, dtf);

        for (String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        int idx = 1;

        for (String privacy : privacies) {
            String standardDate = privacy.split(" ")[0];
            String grade = privacy.split(" ")[1];


            LocalDate compareDate = LocalDate.parse(standardDate, dtf);

            compareDate = compareDate.plusMonths(termMap.get(grade));

            if (now.compareTo(compareDate) >= 0) {
                answer.add(idx);
            }

            idx++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
