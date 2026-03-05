package 프로그래머스;

public class 시저암호 {

    public static void main(String[] args) {

        si_Solution s = new si_Solution();

        System.out.println(s.solution("a B z", 4));   // e F d
        System.out.println(s.solution("Z", 1));       // A
        System.out.println(s.solution("XYZ", 3));     // ABC
        System.out.println(s.solution("Hello World", 5)); // Mjqqt Btwqi
        System.out.println(s.solution("z", 1));       // a
    }
}


class si_Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                if(ch <= 'Z' && ch >= 'A'){
                    ch += n;
                    if(ch > 'Z')
                        ch -= 26;
                }
                else if (ch <= 'z' && ch >= 'a'){
                    ch += n;
                    if(ch > 'z')
                        ch -= 26;
                }
                sb.append(ch);
            }
            else{
                sb.append(' ');
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
