import java.util.*;

public class BOJ16194 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] p = new int [n+1];
		for (int i=1; i<=n; i++) {
			p[i] = kb.nextInt();
		}
		
		int [] d = new int [n+1];
		d = p; //최솟값을 찾는 것이므로, p값을 먼저 넣어 둔 후에 비교해야 오류를 막을 수 있다.
		for(int i=1; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				if (d[i] > d[i-j] + p[j]) {
					d[i] = d[i-j] + p[j];
				}
				
			}
		}
		System.out.println(d[n]);
		kb.close();
	}

}
