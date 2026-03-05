package 프로그래머스;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {

        py_Solution s = new py_Solution();

        String input1 = "pPoooyY";
        boolean result1 = s.solution(input1);
        System.out.println(result1); // true

        String input2 = "Pyy";
        boolean result2 = s.solution(input2);
        System.out.println(result2); // false
    }
}

class py_Solution {
    boolean solution(String s) {
        boolean answer = false;
        int p_count = 0;
        int y_count = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                p_count++;
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                y_count++;
        }

        if(p_count == y_count)
            answer = true;


        return answer;
    }
}
