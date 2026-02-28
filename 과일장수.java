package 프로그래머스;

import java.util.Arrays;

public class 과일장수 {

    public static void main(String[] args) {

        rhk_Solution sol = new rhk_Solution();

        int k1 = 5;
        int m1 = 2;
        int[] score1 = {5, 5, 1, 1};
        System.out.println("                       "+sol.solution(k1, m1, score1)); // 12

        int k2 = 4;
        int m2 = 3;
        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println("                    "+sol.solution(k2, m2, score2)); // 33
    }
}

class rhk_Solution {
    public int solution(int k, int m, int[] score) {

        Arrays.sort(score);
        int box = score.length/m;
        int[] num = new int[score.length];
        int[] minArr = new int[box];
        int count = 0;
        int minNum = 0;


        for(int i = score.length-1; i>=0; i--){
            num[count] = score[i];
            count++;
        }

        for(int i = 0; i < box * m; i += m){
            minArr[minNum] = 9999;
            for(int j = i; j<i+m; j++){
                if(num[j] < minArr[minNum]){
                    minArr[minNum] = num[j];
                }
            }
            minNum++;
        }

        int sum = 0;
        for(int i =0; i<box; i++){
            sum += minArr[i]*m;
        }

        return sum;
    }
}