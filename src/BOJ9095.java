import java.util.*;

public class BOJ9095 { //DP 
	static int [] d;
	static int go(int n) {
		if (n<=2) return n;
		if (n==3) return 4;
		if (d[n]>0) return d[n]; 
		d[n] = go(n-3)+go(n-2)+go(n-1);	
		return d[n];
	}
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		d = new int [11];
		
		int [] r = new int [11];
		for (int i=0; i<t; i++) {
			int k = kb.nextInt();
			r[i] = go(k);
		}
		for (int i=0; i<t; i++) {
			System.out.println(r[i]);
		}
		kb.close();
	}
}

