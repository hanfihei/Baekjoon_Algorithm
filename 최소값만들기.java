package 프로그래머스;

import java.util.Arrays;

public class 최소값만들기 {
}

class Solution9
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length / 2; i++) {
            int temp = B[i];
            B[i] = B[B.length - 1 - i];
            B[B.length - 1 - i] = temp;
        }


        for(int i = 0; i<A.length; i++){
            answer += A[i] * B[i];
        }


        return answer;
    }
}
