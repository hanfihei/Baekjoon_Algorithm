package 프로그래머스;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격__다시 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        int[] prices1 = {1, 2, 3, 2, 3};
        int[] result1 = solution.solution(prices1);
        System.out.println(Arrays.toString(result1)); // [4, 3, 1, 1, 0]

        int[] prices2 = {2, 2, 1};
        int[] result2 = solution.solution(prices2);
        System.out.println(Arrays.toString(result2)); // [2, 1, 0]
    }
}

class Solution7 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        numCount count = new numCount();

        Stack<Integer> st = new Stack<>();


        for(int i = prices.length-1; i > -1; i--) {
            st.push(prices[i]);
        }
        System.out.println("          " +st);

        for(int i = 0; i<prices.length-1; i++) {
            int num = st.pop();
            Stack<Integer> copy = new Stack<>();
            copy.addAll(st);

            answer[i] = count.count(num, copy);
        }


        return answer;
    }
}

class numCount {
    public int count(int num, Stack st) {

        int count = 0;
        System.out.println(st);

        if(num > (int)st.peek()){
            return 1;
        }

        while(!st.isEmpty()) {
            int count2 = (int)st.pop();
            if(num <= count2){
                count++;
            }
            else
                return count+1;
        }


        return count;
    }
}
