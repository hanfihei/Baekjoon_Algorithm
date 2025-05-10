import java.util.Scanner;

public class 숫자의합 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int result = 0;
		int num = s.nextInt();
		
		String str = s.next();
		
		char[] arr = str.toCharArray();
		
		for(int i = 0; i<arr.length; i++) {
			result += arr[i] - '0';
		}
		System.out.println(result);
		
		

	}

}
