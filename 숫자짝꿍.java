package 프로그래머스;

public class 숫자짝꿍 {

    public static void main(String[] args) {

        num_Solution sol = new num_Solution();

        String X1 = "100";
        String Y1 = "2345";
        System.out.println(sol.solution(X1, Y1)); //-1

        String X5 = "5525";
        String Y5 = "1255";
        System.out.println(sol.solution(X5, Y5)); //552
    }
}

class num_Solution {
    public String solution(String X, String Y) {

        int[] newX = new int[10];
        int[] newY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            newX[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            newY[Y.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            int num = Math.min(newX[d], newY[d]);
            for (int i = 0; i < num; i++) {
                sb.append(d);
            }
        }

        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
