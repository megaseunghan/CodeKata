package lv1;

import java.lang.invoke.StringConcatFactory;
import java.util.HashMap;
import java.util.Map;

public class P172928 {
    static int[] start = new int[2];
    static int[][] map;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        map = new int[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                String[] pCol = park[i].split("");
                if (pCol[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                } else if (pCol[j].equals("O")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        Map<String, Integer> move = new HashMap<>();

        for (String route : routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            move(direction, distance);
        }
        return start;
    }

    public void move(String dir, int dis) {
        switch (dir) {
            case "E":
                int x = start[1];
                for (int i = 1; i < dis; i++) {
                    if (start[1] + dis > map[0].length - 1) break;
                    x++;
                    if (map[start[0]][x] == 1) {
                        x -= i;
                        break;
                    }
                }
                start[1] = x;
                break;
            case "W":
                x = start[1];
                for (int i = 1; i < dis; i++) {
                    if (start[1] - dis < 0) break;
                    x--;
                    if (map[start[0]][x] == 1) {
                        x += i;
                        break;
                    }
                }
                start[1] = x;
                break;
            case "N":
                int y = start[0];
                for (int i = 1; i < dis; i++) {
                    if (start[0] - dis < 0) break;
                    y--;
                    if (map[y][start[1]] == 1) {
                        y += i;
                        break;
                    }
                }
                start[0] = y;
                break;
            case "S":
                y = start[0];
                for (int i = 1; i < dis; i++) {
                    if (start[0] + dis > map.length - 1) break;
                    y++;
                    if (map[y][start[1]] == 1) {
                        y -= i;
                        break;
                    }
                }
                start[0] = y;
                break;
        }
    }
}
