package 프로그래머스;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        int[] prices1 = {1, 2, 3, 2, 3};
        int[] result1 = solution.solution(prices1);
        System.out.println(Arrays.toString(result1)); // [4, 3, 1, 1, 0]

        int[] prices2 = {5, 4, 3, 2, 1};
        int[] result2 = solution.solution(prices2);
        System.out.println(Arrays.toString(result2)); // [1, 1, 1, 1, 0]
    }
}

class Solution7 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        numCount count = new numCount();

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            st.push(prices[i]);
        }

        for(int i = 0; !st.isEmpty(); i++) {
            int num = st.pop();
            answer[i] = count.count(num, st);
        }


        return answer;
    }
}

class numCount {
    public int count(int num, Stack st) {

        int count = 0;

        while(!st.isEmpty()) {
            int count2 = st.pop();
            
            if(num )
        }


        return 0;
    }
}
