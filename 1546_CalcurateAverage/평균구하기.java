import java.util.*;

public class 평균구하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		int[] arr = new int[num];
		double avg = 0;
		for(int i = 0; i<num; i++) {
			arr[i] = s.nextInt();
		}
		
		 int max = Arrays.stream(arr)
                 .max()
                 .getAsInt();
		 
		 
		 for(int i = 0; i<num; i++) {
			 avg += (arr[i]/(double)max)*100;
		 }
		 avg /= num;
		 
		 System.out.println(avg);
		 
		 

	}

}
