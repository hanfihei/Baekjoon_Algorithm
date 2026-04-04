package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

//10분 시작
public class 의상 {
    public static void main(String[] args) {
        dml_Solution solution = new dml_Solution();

        // 케이스 1: 한 종류만 있는 경우
        String[][] clothes1 = {
                {"hat1", "headgear"},
                {"hat2", "headgear"}
        };

        // 케이스 2: 모든 종류가 서로 다른 경우
        String[][] clothes2 = {
                {"a", "x"},
                {"b", "y"},
                {"c", "z"}
        };

        // 케이스 3: 한 개만 있는 경우
        String[][] clothes3 = {
                {"only", "single"}
        };

        System.out.println(solution.solution(clothes1));//2
        System.out.println(solution.solution(clothes2));//7
        System.out.println(solution.solution(clothes3));//1
    }
}

class dml_Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int count = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String str = clothes[i][1];
            map.put(str, map.getOrDefault(str, 0) + 1);
            answer++;
        }

        for (int value : map.values()) {
            if(map.size() > 1)
                if(value == 1)
                    count++;
                else
                    count *= value;
        }

        if(count == 1)
            return answer;
        else
            return answer+count;
    }
}
