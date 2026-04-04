package 프로그래머스;

import java.util.Arrays;

//41
public class 전화번호목록__다시 {
    public static void main(String[] args) {
        nu_Solution solution = new nu_Solution();

        String[] phone_book1 = {"119", "97674223", "1195524421"}; // false
        String[] phone_book2 = {"123", "456", "789"}; // true
        String[] phone_book3 = {"12", "123", "1235", "567", "88"}; // false

        System.out.println(solution.solution(phone_book1));
        System.out.println(solution.solution(phone_book2));
        System.out.println(solution.solution(phone_book3));
    }
}

class nu_Solution {
    public boolean solution(String[] phone_book) {

        //정렬해야 최대한 비슷한 숫자랑 엮어줌
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            //접두어만 검사
            if (b.startsWith(a)) {
                return false;
            }
        }

        return true;
    }
}
