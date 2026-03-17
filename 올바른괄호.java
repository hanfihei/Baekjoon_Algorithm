package 프로그래머스;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        System.out.println(solution.solution("()()"));    // true
        System.out.println(solution.solution("(())()"));  // true
        System.out.println(solution.solution(")()("));    // false
        System.out.println(solution.solution("(()("));    // false
    }
}

class Solution6 {
    boolean solution(String s) {
        boolean answer = true;

        char[] array = s.toCharArray();

        Stack<Character> st= new Stack<>();

        for(int i = 0; i<array.length; i++) {
            if(array[i]== '(') {
                st.push(array[i]);
            }
            else if(array[i] == ')') {
                if(st.isEmpty() || st.pop() != '(') {
                    answer = false;

                    return answer;
                }

            }

        }

        return st.isEmpty();
    }
}