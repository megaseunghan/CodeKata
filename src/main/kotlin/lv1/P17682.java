package lv1;

public class P17682 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] dart = new int[3];

        int number = 0, index = 0;
        String numStr = "";
        for (char c : dartResult.toCharArray()) {

            if (Character.isDigit(c)) {
                numStr += String.valueOf(c);

            } else if(c == 'S' || c == 'D' || c == 'T') {
                number = Integer.parseInt(numStr);

                if (c == 'S') {
                    dart[index++] = (int) Math.pow(number, 1);
                } else if (c == 'D') {
                    dart[index++] = (int) Math.pow(number, 2);
                } else if (c == 'T') {
                    dart[index++] = (int) Math.pow(number, 3);
                }
                numStr = "";

            } else {
                if (c == '*') {
                    dart[index - 1] *= 2;
                    if (index - 2 >= 0) dart[index-2] *= 2;
                } else if (c == '#') {
                    dart[index - 1] *= (-1);
                }
            }
        }
        answer = dart[0] + dart[1] + dart[2];

        return answer;
    }
}
