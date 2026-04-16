package 프로그래머스;

import java.util.Arrays;

public class 구명보트__다시 {
    public static void main(String[] args) {
        rn_Solution solution = new rn_Solution();

        System.out.println(solution.solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));     // 3

        System.out.println(solution.solution(new int[]{30, 40, 50, 60}, 100)); // 2
        System.out.println(solution.solution(new int[]{20, 20, 50, 80}, 100)); // 2
        System.out.println(solution.solution(new int[]{40, 40, 60}, 100));     // 2
    }
}

class rn_Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int num = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            num++;
        }

        return num;
    }
}