package 프로그래머스;

import java.util.*;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {

        two_Solution s = new two_Solution();

        int[] numbers = {2, 1, 3, 4, 1};

        int[] result = s.solution(numbers);

        for (int v : result) {
            System.out.print(v + " ");
        }
        // expected: 2 3 4 5 6 7
    }
}

class two_Solution {
    public int[] solution(int[] numbers) {

        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i<numbers.length; i++) {
            int sum = numbers[i];
            for(int j = i+1; j<numbers.length; j++) {
                sum += numbers[j];
                set.add(sum);
                sum = numbers[i];
            }

        }

        int[] answer = new int[set.size()];
        int count = 0;

        for(Integer i : set) {
            answer[count++] = i;
        }

        return answer;
    }
}