package 프로그래머스;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        bu_Solution s = new bu_Solution();

        int[] d1 = {1, 3, 2, 5, 4};
        int budget1 = 9;
        System.out.println(s.solution(d1, budget1)); // expected 3

        int[] d2 = {2, 2, 3, 3};
        int budget2 = 10;
        System.out.println(s.solution(d2, budget2)); // expected 4
    }
}


class bu_Solution {
    public int solution(int[] d, int budget) {

        int sum = 0;
        int count = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum <= budget) {
                count++;
            }
        }

        return count;
    }
}
