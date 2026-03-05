package 프로그래머스;

import java.util.Arrays;

public class 문자열내마음대로정렬하기___다시 {

    public static void main(String[] args) {

        ans_Solution s = new ans_Solution();

        String[] arr1 = {"sun", "bed", "car"};
        int n1 = 1;

        String[] result1 = s.solution(arr1, n1);
        System.out.println(Arrays.toString(result1));
        // expected: [car, bed, sun]


        String[] arr2 = {"abce", "abcd", "cdx"};
        int n2 = 2;

        String[] result2 = s.solution(arr2, n2);
        System.out.println(Arrays.toString(result2));
        // expected: [abcd, abce, cdx]
    }
}

class ans_Solution {

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a, b) -> {
            // 두 문자열 a,b를 비교해서 Arrays.sort가 정렬함

            // n번째 문자가 같으면 문자열 사전순
            if (a.charAt(n) == b.charAt(n)) {
                // 음수 → a 먼저
                // 양수 → b 먼저
                // 0 → 같은 문자열
                return a.compareTo(b);
            }

            // n번째 문자 기준 정렬
            // 음수 → a 먼저
            // 양수 → b 먼저
            return a.charAt(n) - b.charAt(n);
        });

        return strings;
    }
}