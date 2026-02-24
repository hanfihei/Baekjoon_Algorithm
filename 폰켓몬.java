package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {

        pon_Solution s = new pon_Solution();

        int[] nums = {3, 1, 2, 3};
        //최대 2가지

        int result = s.solution(nums);

        System.out.println("최대로 선택 가능한 폰켓몬 수: " + result);
    }
}
class pon_Solution {
    public int solution(int[] nums) {
        int count = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() > count) {
            return count;
        }
        if (set.size() < count) {
            return set.size();
        }

        return count;
    }

}