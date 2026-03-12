package 프로그래머스;

public class 카펫 {
    public static void main(String[] args) {
        zk_Solution s = new zk_Solution();

        int[] result1 = s.solution(10, 2);
        System.out.println(result1[0] + ", " + result1[1]);

        int[] result2 = s.solution(8, 1);
        System.out.println(result2[0] + ", " + result2[1]);

        int[] result3 = s.solution(24, 24);
        System.out.println(result3[0] + ", " + result3[1]);
    }
}

class zk_Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int[] answer = new int[2];

        //가로 * 세로가 total이 되야함
        for(int i = 1; i<=brown; i++) {
            for(int j = 1; j<=brown; j++) {
                if(i*j == total && j >= i) {
                    if(yellow == (j - 2) * (i - 2)) {
                        answer[0] = j;
                        answer[1] = i;
                        return answer;
                    }
                }
            }

        }

        return answer;
    }
}