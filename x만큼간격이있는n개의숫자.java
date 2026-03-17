package 프로그래머스;

public class x만큼간격이있는n개의숫자 {
    public static void main(String[] args) {

        x_Solution s = new x_Solution();

        int x1 = 2;
        int n1 = 5;
        print(s.solution(x1, n1)); // [2, 4, 6, 8, 10]

        int x2 = 4;
        int n2 = 3;
        print(s.solution(x2, n2)); // [4, 8, 12]

        int x3 = -4;
        int n3 = 2;
        print(s.solution(x3, n3)); // [-4, -8]
    }

    static void print(long[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}


class x_Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int count = 0;

        for(long i = x; count<n; i = i+x){
            answer[count++] = i;
        }

        return answer;
    }
}