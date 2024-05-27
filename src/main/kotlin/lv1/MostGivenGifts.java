package lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostGivenGifts {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        int[][] histories = new int[n][n];
        int[] giftScore = new int[n];
        int[] nextMonthGift = new int[n];

        Map<String, Integer> friendsIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            friendsIdx.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            int giver = friendsIdx.get(arr[0]);
            int taker = friendsIdx.get(arr[1]);

            histories[giver][taker]++;

            giftScore[giver]++;
            giftScore[taker]--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int give = histories[i][j];
                int take = histories[j][i];

                if (give > take) {
                    nextMonthGift[i]++;
                } else if (give < take) {
                    nextMonthGift[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGift[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGift[j]++;
                    }
                }
            }
        }
        return Arrays.stream(nextMonthGift).max().getAsInt();
    }
}