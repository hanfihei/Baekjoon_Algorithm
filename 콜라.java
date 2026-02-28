package 프로그래머스;

public class 콜라{
    public static void main(String[] args) {
        col_Solution s = new col_Solution();

        // ❌ b ≠ 1 → 네 코드틀림
        System.out.println(s.solution(3, 2, 20)); // 정답: 36

//        // ❌ 더 극단 (b가 클수록 더 틀림)
//        System.out.println(s.solution(2, 3, 20)); // 정답: 57
//
//        // ❌ 최소 단위에서도 깨짐
//        System.out.println(s.solution(3, 2, 6)); // 정답: 8
//
//        // ❌ 반복 누적에서 차이 커짐
//        System.out.println(s.solution(4, 3, 20)); // 정답: 27
    }
}

class col_Solution {
    public int solution(int a, int b, int n) {
        //받을 수 있는 콜라병의 수
        //a를 가져다 주면 b병을 줌. 병의 수는 n개임

        int count = n;
        int answer = 0;

        while(count >= a) {
            int num = count/a;//바꿀수 있는 병의 수
            int num2 = count%a;// 남은 병
            answer += num*b; // 받은 콜라
            count -= a*num; //바꾼 병을 전체 병에서 빼줌
            count += b*num; //먹고 난 다음의 병
            System.out.println(answer);

        }



        return answer;
    }
}