package lv1;

import java.util.HashMap;
import java.util.Map;

public class P178871 {
    public String[] solution(String[] players, String[] callings) {
        // [kai to 2], [mine to 2]
        // kai = 3 - 2      -> 1 soe swap
        // mine = 4 - 2     -> 2 poe swap
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            idxMap.put(players[i], i);
        }

        for (String call : callings) {
            int curr = idxMap.get(call);
            idxMap.put(call, curr - 1);
            idxMap.put(players[curr - 1], curr);
            players[curr] = players[curr - 1];
            players[curr - 1] = call;
        }

        return new String[0];
    }
}
