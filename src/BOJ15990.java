import java.util.*;

public class BOJ15990 {

	public static int [][] d = new int [1001][4];
	
	
	public static int solve(int n) {
		
		int [] answer = new int [n+1];
		
		d[1][1] = 1;
		d[1][2] = 0;
		d[1][3] = 0;
		
		d[2][1] = 0;
		d[2][2] = 1;
		d[2][3] = 0;
		
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;
				
	
		answer[n] = d[n-2][1] + d[n-3][1] +d[n-1][2]+d[n-3][2]+d[n-1][3]+d[n-2][3];

		
		return answer[n];
	}
	
	
	
	public static void main(String[] args) {
		
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		for (int i=1; i<=n; i++) {
			int k = kb.nextInt();

			System.out.println(solve(k));
		}
	
		kb.close();
	}

}
