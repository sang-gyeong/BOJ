import java.util.*;

public class BOJ2225 {

	
	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int [][]d = new int [201][201];
		long mod = 1000000000;
		
		d[0][0] = 1;
		
		for (int i=1; i<=k; i++) {
			for (int j=0; j<=n; j++) {
				for(int l=0;l<=j;l++) {
					d[i][j] += d[i-1][j-l];
					d[i][j] %= mod;
				}
			}
		}
		System.out.println(d[k][n]);
		kb.close();

	}
	
	
	

}
