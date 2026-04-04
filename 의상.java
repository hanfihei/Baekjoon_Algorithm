package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

//10분 시작
public class 의상 {
    public static void main(String[] args) {
        dml_Solution solution = new dml_Solution();

        // 케이스 4: 종류 2개, 각각 1개씩
        String[][] clothes4 = {
                {"a", "x"},
                {"b", "y"}
        }; // 정답: 3


// 케이스 5: 종류 2개, 하나는 여러개
        String[][] clothes5 = {
                {"a1", "x"},
                {"a2", "x"},
                {"b1", "y"}
        }; // 정답: 5


// 케이스 6: 종류 3개, 개수 섞인 경우
        String[][] clothes6 = {
                {"a1", "x"},
                {"a2", "x"},
                {"b1", "y"},
                {"c1", "z"}
        }; // 정답: 11


// 케이스 8: 종류 3개, 각각 2개씩
        String[][] clothes8 = {
                {"a1", "x"}, {"a2", "x"},
                {"b1", "y"}, {"b2", "y"},
                {"c1", "z"}, {"c2", "z"}
        }; // 정답: 26

        System.out.println(solution.solution(clothes4));//2
        System.out.println(solution.solution(clothes5));//7
        System.out.println(solution.solution(clothes6));//1
        System.out.println(solution.solution(clothes8));//1


    }
}

class dml_Solution {
    public int solution(String[][] clothes) {
        int count = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String str = clothes[i][1];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int value : map.values()) {
            count *= (value + 1);
        }

        return count -1;
    }
}
