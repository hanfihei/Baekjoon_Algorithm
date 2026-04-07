package 프로그래머스;

public class 큰수만들기__다시 {
    public static void main(String[] args) {
        big_Solution solution = new big_Solution();

        System.out.println(solution.solution("1924", 2));       // 94
        System.out.println(solution.solution("1231234", 3));    // 3234
        System.out.println(solution.solution("4177252841", 4)); // 775841
    }
}

class big_Solution {
    public String solution(String number, int k) {

        //스택이나 데크도 가능
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            // 현재 sb에 저장된 모든 숫자와 now를 비교해서 제거
            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) < now) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(now);
        }

        // 채우지 못한 숫자들을 나머지로 채움
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }


        String answer  = sb.toString();



        return answer;
    }
}
