package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Deque;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        dd_Solution sol = new dd_Solution();

        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(sol.solution(bridge_length1, weight1, truck_weights1)); // 8
        System.out.println(sol.solution(bridge_length2, weight2, truck_weights2)); // 101
        System.out.println(sol.solution(bridge_length3, weight3, truck_weights3)); // 110
    }
}

class dd_Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0; // 현재 다리의 무게
        int time = 0;

        Deque<Integer> qu = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            qu.offer(0);
        }

        int i = 0;

        while (true) {
            int num = qu.poll();
            sum -= num;
            if (i < truck_weights.length && sum+truck_weights[i] <= weight) {
                sum += truck_weights[i];
                qu.offer(truck_weights[i]);
                i++;
                time++;
            } else {
                if(sum == 0) {
                    break;
                }
                time++;
                qu.offer(0);
            }
        }


        return ++time;
    }
}
