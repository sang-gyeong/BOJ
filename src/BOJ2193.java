import java.util.*;

public class BOJ2193 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		long [] d = new long [91];
		
		d[1] = 1;
		d[2] = 1;
		
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		
		System.out.println(d[n]);
		kb.close();
	}

}
