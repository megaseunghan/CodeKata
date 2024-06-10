package lv1;

import java.util.HashMap;

public class P160586 {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char target = keymap[i].charAt(j);
                if (map.containsKey(target)) {
                    if (map.get(target) > j + 1) {
                        map.put(target, j + 1);
                    }
                } else {
                    map.put(target, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int nCnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char alpha = (targets[i].charAt(j));
                Integer nMinClick = map.get(alpha);
                if (nMinClick != null) {
                    nCnt += nMinClick;
                } else {
                    nCnt = -1;
                    break;
                }
            }
            answer[i] = nCnt;

        }
        return answer;
    }
}
