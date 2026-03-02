package 프로그래머스;

import java.util.Arrays;

public class k번째수 {

    public static void main(String[] args) {

        k_Solution sol = new k_Solution();

        int[] array = {10, 2, 3};
        int[][] commands = {
                {1, 3, 2}
        };

        int[] result = sol.solution(array, commands);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}

class k_Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[][] arr = new int[commands.length][];

        for (int i = 0; i < commands.length; i++) {

            int start = commands[i][0] - 1;
            int end = commands[i][1];

            arr[i] = new int[end - start];

            int idx = 0;
            for (int j = start; j < end; j++) {
                arr[i][idx++] = array[j];
            }
        }

        int[] answer = new int[commands.length];

        for (int i = 0; i < arr.length; i++) {

            Arrays.sort(arr[i]);

            int k = commands[i][2];
            answer[i] = arr[i][k - 1];
        }

        return answer;
    }
}