package 프로그래머스;

public class 이상한문자만들기 {
    public static void main(String[] args) {

        str_Solution s = new str_Solution();

        String input1 = "try hello world";
        String result1 = s.solution(input1);
        System.out.println(result1); // expected: "TrY HeLlO WoRlD"

        String input2 = "  abc  def   gh ";
        String result2 = s.solution(input2);
        System.out.println(result2); // 공백 유지되는지 확인용
    }
}

class str_Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int check = 0;

        while (count < s.length()) {
            if (s.charAt(count) != ' ') {
                check = 0;
                for(int j = count; j<s.length() && ' ' != s.charAt(j); j++){
                    if(check++%2 == 0) {
                        char ch = Character.toUpperCase(s.charAt(j));
                        sb.append(ch);
                        count++;
                    }
                    else {
                        char ch = Character.toLowerCase(s.charAt(j));
                        sb.append(ch);
                        count++;
                    }
                }
            }

            else {
                sb.append(s.charAt(count));
                count++;
            }
        }

        String answer = sb.toString();

        return answer;
    }
}
