package 프로그래머스;

public class 다음큰숫자 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();

        int n1 = 78;
        int n2 = 15;

        System.out.println(sol.solution(n1)); // 83
        System.out.println(sol.solution(n2)); // 23
    }
}

class Solution10 {
    public int solution(int n) {
        int count = Integer.bitCount(n);

        int num = -9999;

       while(true) {
           num = Integer.bitCount(++n);
           if(num == count){
               return n;
           }
       }

    }
}