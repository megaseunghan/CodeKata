package programmers;

import java.util.ArrayList;

public class P258711 {

    // 탐색해서 출발 2개인 정점 있으면 8자
    // 탐색해서 기존 꺼로 돌아오면 도넛
    // 탐색해서 끝이 있으면 막대
    ArrayList<Integer>[] edgeLists;


    public int[] solution(int[][] edges) {

        // 생성점 찾기
        int startNum = findStart(edges);


        if (startNum == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[4];
        answer[0] = startNum;
        for (int startEdge : edgeLists[startNum]) {
            int form = dfs(startEdge,startEdge);
            answer[form]++;
        }
        return answer;
    }

    public int dfs(int n, int startEdge) {
        ArrayList<Integer> arr = edgeLists[n];
        if(arr.size() == 0){
            return 2;
        }
        if(arr.size() == 2){
            return 3;
        }
        if(arr.get(0) == startEdge){
            return 1;
        }
        return dfs(arr.get(0),startEdge);
    }

    public int findStart(int[][] edges) {
        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        edgeLists = new ArrayList[max + 1];
        for (int i = 0; i < max + 1; i++) {
            edgeLists[i] = new ArrayList<>();
        }
        int start[] = new int[max + 1];
        int end[] = new int[max + 1];
        for (int[] edge : edges) {
            start[edge[0]]++;
            end[edge[1]]++;
            edgeLists[edge[0]].add(edge[1]);
        }
        for (int i = 1; i < max + 1; i++) {
            if (end[i] == 0 && start[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}