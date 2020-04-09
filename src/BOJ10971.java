import java.util.*;
public class BOJ10971 {

	static boolean next_permutation(int [] a) {
		int i = a.length-1;
		while (i>0 && a[i-1]>=a[i]) {
			i--;
		}
		if (i<=0) {
			return false;
		}
		int j = a.length - 1;
		while (a[j]<=a[i-1]) {
			j--;
		}
		int tmp = a[j];
		a[j] = a[i-1];
		a[i-1] = tmp;

		j = a.length -1; 
		while (i<j) {
			tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [][]a = new int [n+1][n+1];
		int [] b = new int [n]; 
		
		for(int i=1; i<=n; i++) {
			for (int j=1; j<=n ; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		for (int i=0; i<n; i++) {
			b[i] = i+1;
		}
		
		int ans = 4000000;
		do {
			boolean ok = true;
			int sum = 0;
			for (int i=0; i<n-1;i++) {
				if (a[b[i]][b[i+1]]==0) ok = false; //체크 
				sum += a[b[i]][b[i+1]];
			}
			if (a[b[n-1]][b[0]]==0) ok = false; //체크 
			sum += a[b[n-1]][b[0]];
			if (ans>sum && ok) ans = sum;
			
		}while(next_permutation(b));
		
		
		System.out.println(ans);
	
	}

}
