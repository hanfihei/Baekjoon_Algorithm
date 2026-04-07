package 프로그래머스;

public class 피로도__다시 {
    public static void main(String[] args) {
        p_Solution solution = new p_Solution();

        int k1 = 90;
        int[][] dungeons1 = {
                {80, 20},
                {30, 10},
                {40, 10},
                {50, 30}
        };


        int result1 = solution.solution(k1, dungeons1);
        System.out.println(result1); // 기대값: 3
    }
}

class p_Solution {
    public int solution(int k, int[][] dungeons) {
        int count = 0;

        for(int i = 0; i < dungeons.length; i++) {
            int max = dungeons[i][0];
            for(int j = 0; j < dungeons.length; j++) {
                int num = dungeons[j][0];
                if(max < num) {
                    int temp = dungeons[i][0];
                    int temp2 = dungeons[i][1];
                    dungeons[i][0] = dungeons[j][0];
                    dungeons[i][1] = dungeons[j][1];
                    dungeons[j][0] = temp;
                    dungeons[j][1] = temp2;
                    max = dungeons[i][0];
                }
            }
        }

        for(int i = 0; i < dungeons.length; i++) {
            int num = dungeons[i][0];
            int num2 = dungeons[i][1];
            if(num > k){
                return ++count;
            }
            k -= num2;
            count++;
        }


        return count;
    }
}
