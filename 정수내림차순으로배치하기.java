package 프로그래머스;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    public static void main(String[] args) {

        u_Solution s = new u_Solution();

        System.out.println(s.solution(118372)); // 기대값: 873211
        System.out.println(s.solution(1021));   // 기대값: 2110
        System.out.println(s.solution(987654)); // 기대값: 987654
    }
}

class u_Solution {
    public long solution(long n) {

        String a = String.valueOf(n);

        String[] str = new String[a.length()];

        for(int i = 0; i < a.length(); i++){
            str[i] = String.valueOf(a.charAt(i));
        }

        Arrays.sort(str, Collections.reverseOrder());

        String result = "";

        for(String s : str){
            result += s;
        }

        long answer = Long.parseLong(result);

        return answer;
    }
}


