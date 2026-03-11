package 프로그래머스;

import java.util.Arrays;

public class 모의고사 {

    public static void main(String[] args) {

        mo_Solution s = new mo_Solution();

        int[] answers1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(s.solution(answers1)));

        int[] answers2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(s.solution(answers2)));

        int[] answers3 = {3,3,2,1,5,4,2,1,3,5};
        System.out.println(Arrays.toString(s.solution(answers3)));
    }

}

class mo_Solution {
    public int[] solution(int[] answers) {

        int[] arr1 = new int[answers.length+6];
        for(int i = 0; i<answers.length; i = i+5){
            arr1[i] = 1;
            arr1[i+1] = 2;
            arr1[i+2] = 3;
            arr1[i+3] = 4;
            arr1[i+4] = 5;
        }

        int[] arr2 = new int[answers.length+9];
        for(int i = 0; i<answers.length; i = i+8){
            arr2[i] = 2;
            arr2[i+1] = 1;
            arr2[i+2] = 2;
            arr2[i+3] = 3;
            arr2[i+4] = 2;
            arr2[i+5] = 4;
            arr2[i+6] = 2;
            arr2[i+7] = 5;
        }

        int[] arr3 = new int[answers.length+11];
        for(int i = 0; i<answers.length; i = i+10){
            arr3[i] = 3;
            arr3[i+1] = 3;
            arr3[i+2] = 1;
            arr3[i+3] = 1;
            arr3[i+4] = 2;
            arr3[i+5] = 2;
            arr3[i+6] = 4;
            arr3[i+7] = 4;
            arr3[i+8] = 5;
            arr3[i+9] = 5;
        }

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        for(int i = 0; i<answers.length; i++){
            if(answers[i] == arr1[i])
                num1++;
            if(answers[i] == arr2[i])
                num2++;
            if(answers[i] == arr3[i])
                num3++;
        }

        int[] answer = new int[3];

        if(num1 > num2 && num1 >num3)
            answer[0] = 1;

        else if(num2 > num1 && num2 > num3)
            answer[0] = 2;

        else if(num3 > num1 && num3 > num2)
            answer[0] = 3;

        else if(num1 == num2 && num1 > num3){
            answer[0] = 1;
            answer[1] = 2;
        }

        else if(num2 == num3 && num2 > num1){
            answer[0] = 2;
            answer[1] = 3;
        }

        else if(num1 == num3 && num1 > num2){
            answer[0] = 1;
            answer[1] = 3;
        }

        else if(num1 == num2 && num2 == num3){
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }

        int count = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) count++;
        }

        int[] result = Arrays.copyOf(answer, count);

        return result;
    }
}
