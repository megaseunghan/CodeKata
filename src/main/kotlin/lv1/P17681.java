package lv1;

public class P17681 {
    String s1, s2;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            s1 = Integer.toBinaryString(arr1[i]); // 01001
            s2 = Integer.toBinaryString(arr2[i]); // 11110

            while (s1.length() < n) {
                s1 = "0" + s1;
            }

            while (s2.length() < n) {
                s2 = "0" + s2;
            }

            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '1' && s2.charAt(j) == '1') {
                    sb.append('#');
                } else if (s1.charAt(j) == '1' && s2.charAt(j) == '0') {
                    sb.append('#');
                } else if (s1.charAt(j) == '0' && s2.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
            sb = new StringBuilder();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = new P17681().solution(5,
                new int[]{9, 20, 28, 18, 11},
                new int[]{30, 1, 21, 17, 28
                });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
