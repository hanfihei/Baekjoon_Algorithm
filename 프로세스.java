package 프로그래머스;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        pr_Solution sol = new pr_Solution();

        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(sol.solution(priorities1, location1)); // 1
        System.out.println(sol.solution(priorities2, location2)); // 5
    }
}


class pr_Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        int max = 0;

        Queue<int[]> q = new LinkedList<>();

        int n = priorities[location];
        int maxIndex = 0;

        for(int i = 0; i < priorities.length; i++) {
            int[] nnn = new int[]{priorities[i], i};
            q.offer(nnn);
        }

        Arrays.sort(priorities);
        Integer[] arr = new Integer[priorities.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = priorities[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());

        //index가 length이면 답임
        while(!q.isEmpty()) {
            int now[] = q.poll();
            int pri = now[0]; //우선순위 값
            int index = now[1]; //위치

            if(pri == arr[max] && location == index) {
                return ++count;
            }
            else if(pri == arr[max]) {
                max++;
                count++;
            }
            else
                q.offer(new int[]{pri, index});
        }

        return count;
    }
}