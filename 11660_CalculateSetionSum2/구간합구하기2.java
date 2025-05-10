//시간초과
//.md파일에 수정한 코드 있음
import java.util.*;

public class 구간합구하기2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int sum = 0;
		int n = s.nextInt();
		int num = s.nextInt();
		
		int[][] x = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				x[i][j] = s.nextInt();
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
			}
			System.out.println();
		}
		for(int i = 0; i<num; i++) {
			int xstart = s.nextInt();
			int ystart = s.nextInt();
			int xend  = s.nextInt();
			int yend = s.nextInt();
		
		for(int a = xstart-1; a<xend; a++) {
			for(int b = ystart-1; b<yend; b++) {
				sum += x[a][b];
			}
		}
		System.out.println(sum);
		sum = 0;
		
		}

	}

}
