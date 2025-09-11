package 프로그래머스;

public class 유연근무제 {

	public static void main(String[] args) {
		
		int[] schedules = {759, 0100, 2359};
		int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
		
		int startday = 1;
		
		Solution111 s = new Solution111();
		
        int result = s.solution111(schedules, timelogs, startday);
        System.out.println("답: " + result);

	}

}

class Solution111 {
    public int solution111(int[] s, int[][] t, int startday) {
    	
        int answer = 0;
        int day1;
        int day2;
        int ok = 0;
        
        switch (startday) {
        	case 1:
        		day1 = 5;
        		day2 = 6;
        		break;
        	case 2:
        		day1 = 6;
        		day2 = 0;
        		break;
        	case 3:
        		day1 = 0;
        		day2 = 1;
        		break;
        	case 4:
        		day1 = 1;
        		day2 = 2;
        		break;
        	case 5:
        		day1 = 2;
        		day2 = 3;
        		break;
        	case 6:
        		day1 = 3;
        		day2 = 4;
        		break;
        	default:
        		day1 = 4;
        		day2 = 5;
        }
        
        for(int i = 0; i<s.length; i++) {
        	
        	ok = 1;
        	
        	int h = (s[i]/100)*100;
        	int m = (s[i]%100)+10;
        	if(m>=60) {
        		h += 100;
        		m -= 60;
        	}
        	
        	if(h == 2400) {
        		h = 0;
        		s[i] = h*100 + m;
        	}
        	else
        		s[i] = h+m;
        	
        	for(int j = 0; j<7; j++) {
        		int dayOfWeek = (startday - 1 + j) % 7;
        		
        		if(t[i][j] <= s[i]) { 
        			continue;
        		}
        		else if (dayOfWeek == 5 || dayOfWeek == 6) continue;
        		
        		else {
        			ok = 0;
        			break;
        		}
        	}
        	if(ok == 1) 
        		answer++;
        		
        }
         
        return answer;
    }
}
