package 프로그래머스;

import java.util.Collections;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        the_Solution sol = new the_Solution();

        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;

        int[] scoville2 = {1, 1, 1};
        int K2 = 10;

        System.out.println(sol.solution(scoville1, K1)); // 2
        System.out.println(sol.solution(scoville2, K2)); // -1
    }
}

class the_Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        int min1 = 0;

        while(true) {
            min1 = pq.poll();
            if(min1 >= K)
                break;
            if(pq.peek() == null){
                return -1;
            }
            int min2 = 0;
            if(pq.peek() != null) {
                min2 = pq.poll();
            }
            else
                break;
            int new_food = min1 + (min2 * 2);
            pq.offer(new_food);
            count++;
        }

        return count;
    }
}