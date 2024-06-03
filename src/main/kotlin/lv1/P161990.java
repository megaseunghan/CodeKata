package lv1;

public class P161990 {
    int lux = Integer.MAX_VALUE; // x축 시작값
    int luy = Integer.MAX_VALUE; // y축 시작값
    int rdx = Integer.MIN_VALUE; // x축 끝 값
    int rdy = Integer.MIN_VALUE; // y축 끝 값

    public int[] solution(String[] wallpaper) {

        int yIndex = 0; // y축 인덱스
        for (String w : wallpaper) {
            if (w.contains("#")) { // y축 시작과 끝 점을 구함
                luy = Integer.min(luy, yIndex);
                rdy = Integer.max(rdy, yIndex) + 1;
            }

            if (w.indexOf("#") != -1) { // 파일이 있는지 확인하고, 첫 번째 인덱스, 마지막 인덱스를 구해서 x축의 양 끝 값을 구함
                lux = Integer.min(lux, w.indexOf("#"));
                rdx = Integer.max(rdx, w.lastIndexOf("#") + 1);
            }
            yIndex++;
        }
        return new int[]{luy, lux, rdy, rdx};
    }
}
