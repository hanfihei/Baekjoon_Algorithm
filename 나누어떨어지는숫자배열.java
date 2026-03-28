package 프로그래머스;

import java.util.*;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        aa_Solution sol = new aa_Solution();

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        int[] result = sol.solution(arr, divisor);
        System.out.println(Arrays.toString(result));
    }
}

class aa_Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
