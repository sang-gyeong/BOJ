import java.util.*;

public class BOJ1699 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);	
		int n = kb.nextInt();
		int [] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			d[i] = i;
			for (int j=1; j*j<=i;j++) {
				if (d[i]>d[i-j*j]+1) {
					d[i] = d[i-j*j]+1;
				}
			}	
		}
		
		System.out.println(d[n]);
		kb.close();
	}
}





