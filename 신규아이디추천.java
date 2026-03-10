package 프로그래머스;

public class 신규아이디추천 {
    public static void main(String[] args) {

        new_Solution s = new new_Solution();

        System.out.println(s.solution(""));               // 빈 문자열
        System.out.println(s.solution("."));              // 점 하나
        System.out.println(s.solution("..."));            // 점 여러개
        System.out.println(s.solution("0"));              // 숫자 0
        System.out.println(s.solution("a."));             // 마지막 점
        System.out.println(s.solution(".a"));             // 시작 점
        System.out.println(s.solution(".a."));            // 앞뒤 점
        System.out.println(s.solution("..a.."));          // 연속 점
        System.out.println(s.solution("........"));       // 점만 있는 경우
        System.out.println(s.solution("A"));              // 대문자 하나
        System.out.println(s.solution("12345678901234567890")); // 길이 초과
        System.out.println(s.solution("!@#$%^&*()"));     // 허용 문자 없음
        System.out.println(s.solution("-.~!@#$%"));       // 일부 허용 문자
        System.out.println(s.solution("a"));              // 길이 1
        System.out.println(s.solution("ab"));             // 길이 2
        System.out.println(s.solution("abcdefghijklmn.p"));// 공식 테스트
    }
}


class new_Solution {
    public String solution(String new_id) {

        String answer = "";

        //...!@BaT#*..y.abcdefghijklm

        StringBuilder sb = new StringBuilder();


        //1. 소문자
        for(int i = 0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
                if(ch >= 65 && ch <= 90) {
                    ch += 32;
                    sb.append(ch);
                }
                else
                    sb.append(ch);
        }





        //2. 알파벳, 숫자, -, _, .를 제외한 모든 문자 제거
        for(int i = 0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '-' || ch == '_' || ch == '.' || (ch >= 'a' && ch <='z') || (ch <= '9' && ch >= '0')) {
                continue;
            }
            else {
                sb.deleteCharAt(i);
                i--;
            }
        }



        //3. .. -> .
        for(int i = 0; i<sb.length()-1; i++) {
            char ch = sb.charAt(i);
            char ch2 = sb.charAt(i+1);

            if(ch == '.' && ch2 == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }


        // 4. 처음과 끝의 . 제거
        if (sb.length() >= 1) {
            if (sb.charAt(0) == '.') {
                sb.deleteCharAt(0);
            }
        }

        if (sb.length() >= 1) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }



        //5. 빈문자열 -> "a"대입
        if (sb.length() == 0) {
            sb.append('a');
        }



        //6. length가 16이상이면 첫 15개만 남김 -> .이 마지막이 된다면 .제거
            for(int i = 0; i<sb.length(); i++) {
                if(i>14)
                    sb.deleteCharAt(i--);
            }

            if(sb.length()>0) {
                char end_ch = sb.charAt(sb.length()-1);
                if(end_ch == '.' ) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }





        //7. length가 2 이하라면 @마지막 문자@를 id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(sb.length()<3) {
            char ch4 = sb.charAt(sb.length()-1);
            for(int i = 0; i<4; i++) {
                if(i > sb.length()){
                    sb.append(ch4);
                }
            }


        }







        answer = sb.toString();







        return answer;
    }
}





