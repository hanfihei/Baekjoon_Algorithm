package 프로그래머스;

public class 개인정보수집유효기간_다시 {

    public static void main(String[] args) {

        pe_Solution s = new pe_Solution();

        String today = "2022.05.19";

        String[] terms = {
                "A 6",
                "B 12",
                "C 3"
        };

        String[] privacies = {
                "2021.05.02 A",
                "2021.07.01 B",
                "2022.02.19 C",
                "2022.02.20 C"
        };

        int[] result = s.solution(today, terms, privacies);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}

class pe_Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        String[] to_dateArr = today.split("\\.");

        int to_year = Integer.parseInt(to_dateArr[0]);
        int to_month = Integer.parseInt(to_dateArr[1]);
        int to_day = Integer.parseInt(to_dateArr[2]);

        int toDaySum = to_year * 336 + to_month * 28 + to_day;


        String[] arr = new String[privacies.length];
        int[] privaciesDate = new int[privacies.length];

        for(int i = 0; i<privacies.length; i++) {
            int sum = 0;
            String[] temp = privacies[i].split(" ");

            String date = temp[0];
            arr[i] = temp[1];

            String[] dateArr = date.split("\\.");

            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);
            sum += year * 336 + month * 28 + day;
            privaciesDate[i] = sum;

        }


        int[] answer = {};
        return answer;
    }
}
