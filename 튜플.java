package 프로그래머스;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        tu_Solution solution = new tu_Solution();

        System.out.println(Arrays.toString(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solution.solution("{{20,111},{111}}"))); // [111, 20]
        System.out.println(Arrays.toString(solution.solution("{{123}}"))); // [123]
        System.out.println(Arrays.toString(solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); // [3, 2, 4, 1]
    }
}

class tu_Solution {
    public int[] solution(String s) {

        s = s.substring(1, s.length() - 1);
        String[] arr = s.split("\\},\\{");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", "").replace("}", "");
        }

        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String[] nums = str.split(",");

            for (int j = 0; j < nums.length; j++) {
                int value = Integer.parseInt(nums[j]);

                if (!set.contains(value)) {
                    set.add(value);
                    list.add(value);
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;


    }
}