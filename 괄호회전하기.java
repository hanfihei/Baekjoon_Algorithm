package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        rhkf_Solution sol = new rhkf_Solution();

        String s = "[](){}";

        int result = sol.solution(s);

        System.out.println(result);
    }
}

class rhkf_Solution {
    public int solution(String s) {
        int answer = 0;

        // 일단 다 큐에 넣고
        // 다 넣고 그 뭐엿지 암튼 {일떄 개수를 세고 }로 닫으면서 개수를 세고 나머지에 0이 아니면 false임
        // 그런식으로 하고 for문을 s.length만큼 돌리면서 앞쪽에서 뺴고 그걸 뒤쪽에 넣어서 반복함


        boolean ch = aaa(s);
        if(ch) {
            answer++;
        }

        // 3. 문자열 자르기
        for(int i = 0; i < s.length()-1; i++) {
            char a = s.charAt(0);
            String str = s.substring(1, s.length());
            s = str + a;
            boolean check = aaa(s);
            if(check) {
                answer++;
            }
        }


        return answer;
    }



    public boolean aaa(String s){

        boolean ok = true;
        Stack<Character> st = new Stack<>();

        // 2. 괄호 유무 검사
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    ok = false;
                    break;
                }

                char top = st.pop();

                if (ch == ')' || ch == '}' || ch == ']') {
                    if (ch == ')' && top != '(') {
                        ok = false;
                        break;
                    }
                    if (ch == '}' && top != '{') {
                        ok = false;
                        break;
                    }
                    if (ch == ']' && top != '[') {
                        ok = false;
                        break;
                    }
                }
            }
        }
        if(!st.isEmpty()) {
            ok = false;
        }
        return ok;

    }
}
