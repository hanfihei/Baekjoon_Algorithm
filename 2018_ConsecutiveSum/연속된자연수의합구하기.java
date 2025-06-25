import java.util.*;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int start = 1, end = 1;
		int result = 0;
		int sum = 0;
		
		while(start<=n) {
			if(n == sum)
				result++;
			
			if(sum>=n) {
				sum -= start;
				start++;
			}
			else {
				end++;
				sum += end;
			}
		}
		
		
		System.out.println(result);

	}

}
