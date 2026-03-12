package 프로그래머스;

public class 약수의개수와덧셈 {

    public static void main(String[] args) {

        dir_Solution s = new dir_Solution();

        System.out.println(s.solution(13, 17)); // 기대값: 43
        System.out.println(s.solution(24, 27)); // 기대값: 52
    }
}

class dir_Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }
}
