import java.util.Scanner;

public class 구간합구하기 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		int num2 = s.nextInt();
		
		int[] arr = new int[num+1];
		int[] sum = new int[num+1];
		
		sum[0] = 0;
		
		for(int i = 1; i<num+1; i++) {
			arr[i] = s.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		
		
		for(int i = 0; i<num2; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
		
			System.out.println(sum[end]-sum[start-1]);
		}

	}

}
