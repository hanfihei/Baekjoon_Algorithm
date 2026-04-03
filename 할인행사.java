package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        sa_Solution sol = new sa_Solution();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"
        };

        int result = sol.solution(want, number, discount);
        System.out.println(result);
    }
}


class sa_Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length-9; i++) {
            int sum = 0;
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = i; j < i+10; j++) {
                String item = discount[j];
                int num = copy.getOrDefault(item, 0);
                if(copy.containsKey(item) && num > 0) {
                    copy.put(item,copy.get(item) - 1);
                    sum++;
                }
            }
            if(sum == 10) {
                count++;
                System.out.println(i);
            }
        }

        return count;
    }
}
