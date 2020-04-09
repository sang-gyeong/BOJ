import java.util.*;

public class BOJ11053 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] a = new int [1001];
		int [] d = new int [1001];

		for (int i=1; i<=n; i++) {
			a[i] = kb.nextInt();
		}

		for (int i=1; i<=n; i++) {
			d[i] = 1;
			int tmp = 1;
			for (int j=i-1; j>=1; j--) {
				if (a[j] < a[i]&&d[j]+1>tmp) {
					tmp=d[j]+1;
				}
			}	
			d[i]=tmp;
		}
		int max=1;
		for (int i=1; i<=n; i++) {
			if (d[i]>max) {
				max = d[i];
			}
		}

		kb.close();
		System.out.println(max);
	}
}
