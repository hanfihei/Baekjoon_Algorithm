package 프로그래머스;

import java.util.*;

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

        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        Map<String, Integer> dc = new HashMap();
        // 10일치 먼저 넣기
        for(int i = 0; i < 10; i++) {
            String item = discount[i];
            dc.put(item, dc.getOrDefault(item, 0) + 1);
        }

        if (map.equals(dc)) {
            count++;
        }

        int num = 0;


        // 10일 이후
        for(int i = 10; i<discount.length; i++) {

            String item = discount[num++];
            dc.put(item, dc.getOrDefault(item, 0) - 1);

            // 이 처리를 안 해주면 map.equals(dc)가 제대로 실행되지 않음
            if (dc.get(item) == 0) {
                dc.remove(item);
            }

            String item2 = discount[i];
            dc.put(item2, dc.getOrDefault(item2, 0) + 1);

            if (map.equals(dc)) {
                count++;
            }


        }

        return count;
    }
}
