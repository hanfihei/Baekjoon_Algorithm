package 프로그래머스;

public class 피보나치 {
    public static void main(String[] args) {
        int n = 5;

        fi_Solution solution = new fi_Solution();
        int result = solution.solution(n);
        System.out.println(result);
    }
}

class fi_Solution {
    public int solution(int n) {

        if (n <= 1) return n;

        //배열에 저장해서 불필요한 호출을 줄여야함
        int answer = fi(n);


        return answer;
    }

    public int fi(int n){
        int[] arr = new int[n+1];
        // 고정
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++){
            //계산 후 수를 잘라야함
            arr[i] = (arr[i-1] + arr[i-2]) %1234567;
        }


        return arr[n];
    }
}