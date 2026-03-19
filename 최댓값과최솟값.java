package 프로그래머스;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        String s1 = "0 0 0";
        String s2 = "10 20 -30 40";
        String s3 = "0 -1 -2 -3";
        String s4 = "-5";

        System.out.println(solution.solution(s1)); // 0 0
        System.out.println(solution.solution(s2)); // -30 40
        System.out.println(solution.solution(s3)); // -3 0
        System.out.println(solution.solution(s4)); // -5 -5
    }
}

class Solution8 {
    public String solution(String s) {

        int min = 99999;
        int max = -99999;

        int[] intArr = new int[s.length()];
        String[] strArr = s.split(" ");

        for (int i = 0; i < strArr.length; i++) {
            int num = Integer.parseInt(strArr[i]);
            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }

        String answer = min + " " + max;

        return answer;


    }
}
