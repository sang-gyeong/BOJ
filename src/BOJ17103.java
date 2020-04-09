import java.util.*;

public class BOJ17103 {

	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		
		int t = kb.nextInt();
		while (t-->0) {
			int n = kb.nextInt();
			int count = 0;
			
			boolean [] check = new boolean[n+1]; //지워졌으면 true 
			int pn = 0;
			int [] prime = new int [n];
			
			for (int i=2;i<=n;i++) {
				if(check[i]==false) {
					prime[pn++]=i;
					for (int j=2*i;j<=n;j+=i) {
						check[j]=true;
					}
				}
			}
			for (int i=1;i<=pn;i++) {
				if(check[n-prime[i]]==false&&prime[i]<=n/2) {
					count++;
				}
			}
			System.out.println(count);
		}	
		kb.close();
	}

}
