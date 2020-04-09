import java.util.*;

public class BOJ17087 {

	public static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		else {
			return gcd(b,a%b);
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int s = kb.nextInt();
		int [] d = new int [n];


		for (int i=0;i<n;i++) {
			d[i] = Math.abs(s-kb.nextInt());
		}

		int ans = d[0];
		for (int i=1;i<n;i++) {
			if (ans > gcd(ans,d[i])) {
				ans = gcd(ans,d[i]);
			}	
		}
		System.out.println(ans);
		kb.close();
	}

}


