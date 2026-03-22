package 프로그래머스;

public class 기능개발 {
    public static void main(String[] args) {
        gi_Solution sol = new gi_Solution();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] result1 = sol.solution(progresses1, speeds1);
        int[] result2 = sol.solution(progresses2, speeds2);

        for (int x : result1) {
            System.out.print(x + " ");
        }
        System.out.println(); // 2 1

        for (int x : result2) {
            System.out.print(x + " ");
        }
        System.out.println(); // 1 3 2
    }
}
class gi_Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] countArr = new int[progresses.length];

        int num = 0;

        for(int i = 0; i < progresses.length; i++) {
            for(int j = 1; j < 10000; j++) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100) {
                    countArr[num++] = j;//j가 j번째 완료일
                    break;
                }
            }

        }

        int num2 = 0;
        int[] answer = new int[countArr.length];
        int current = countArr[0];
        int sum = 1;

        for(int i = 1; i < countArr.length; i++) {
            if(current >= countArr[i]) {
                sum++;
            }
            else {
                answer[num2++] = sum;
                sum = 1;
                current = countArr[i];
            }
            if(i == countArr.length - 1) {
                answer[num2++] = sum;
            }
        }
        int[] arr = new int[num2];

        for(int i = 0; i <num2; i++) {
            arr[i] = answer[i];
        }

        return answer;
    }
}
