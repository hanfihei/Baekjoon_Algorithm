package 프로그래머스;
import java.util.*;

public class PCCE기출문제_9번_지폐접기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    Solution s = new Solution();
	     
		int[] wal = {30,15};
		int[] bill = {26, 17};
		
        int result = s.solution(wal, bill);

        System.out.println("필요한 접기 횟수: " + result);
		
		
		
	}
	
	

}
class Solution {
    public int solution(int[] wal, int[] bill) {
    	
    int answer = 0;
	int min = Math.min(wal[0], wal[1]);
	int max = Math.max(wal[0], wal[1]);
	
	int min2 = Math.min(bill[0], bill[1]);
	int max2 = Math.max(bill[0], bill[1]);
    
    
    while(min < min2 || max < max2) {
    	
    	if(bill[0]<bill[1]) {
    		bill[1] = bill[1]/2;
    		answer++;
    	}
    	else {
    		bill[0] = bill[0]/2;
    		answer++;
    	}
    	
    	min2 = Math.min(bill[0], bill[1]);
    	max2 = Math.max(bill[0], bill[1]);
    	
    }
     
        
       
        return answer;
    }
}

