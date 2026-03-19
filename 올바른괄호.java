package 프로그래머스;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        System.out.println(solution.solution("())(()"));    // true
        System.out.println(solution.solution("(())()"));  // true
        System.out.println(solution.solution(")()("));    // false
        System.out.println(solution.solution("(()("));    // false
    }
}

class Solution6 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            if(stack.isEmpty()){
                break;
            }
            if(c == ')'){
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }


        return answer;
    }
}