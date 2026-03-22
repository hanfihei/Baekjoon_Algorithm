package 프로그래머스;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        e_Solution sol = new e_Solution();

        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        int[] result1 = sol.solution(s1);
        int[] result2 = sol.solution(s2);
        int[] result3 = sol.solution(s3);

        System.out.println(result1[0] + ", " + result1[1]); // [3, 8]
        System.out.println(result2[0] + ", " + result2[1]); // [3, 3]
        System.out.println(result3[0] + ", " + result3[1]); // [4, 1]
    }
}


class e_Solution {
    public int[] solution(String s) {


        int count = 0;
        int count_0 = 0;
        String result = "";


        while (!s.equals("1")){
            int len = s.length();
            s = s.replace("0", "");
            count_0 += len - s.length();
            count++;
            s = Integer.toBinaryString(s.length());//길이를 2진수로 바꿔서 다시 s에 저장
        }

        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = count_0;

        return answer;
    }
}