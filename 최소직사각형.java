package 프로그래머스;

public class 최소직사각형 {
    public static void main(String[] args) {

        min_Solution s = new min_Solution();

        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        int result = s.solution(sizes);

        System.out.println(result); // expected: 4000
    }
}

class min_Solution {
    public int solution(int[][] sizes) {

        for(int i = 0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int max = 0;
        int max2 = 0;

        for(int i = 0; i<sizes.length; i++) {
            if(sizes[i][0] > max){
                max = sizes[i][0];
            }
            if(sizes[i][1] > max2){
                max2 = sizes[i][1];
            }
        }

        int answer = max*max2;

        return answer;
    }
}
