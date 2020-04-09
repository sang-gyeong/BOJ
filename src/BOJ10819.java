import java.util.*;
public class BOJ10819 {
	static boolean permutation(int [] a) {
		int i = a.length -1;
		while (i>0 && a[i-1]>=a[i]) {
			i-=1;
		}

		if (i<=0) {
			return false;
		}

		int j = a.length -1;
		while (a[j]<=a[i-1]) {
			j-=1;
		}

		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;

		j = a.length-1;
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
		int [] a = new int [n];

		for (int i=0; i<n;i++) {
			a[i] = kb.nextInt();
		}

		Arrays.sort(a);

		int ans = 0;
		do {
			int sum = 0;
			for (int i=1; i<n;i++) {
				sum += Math.abs(a[i]-a[i-1]);
			}
			if (sum>ans) ans = sum;
		}
		while(permutation(a));

		System.out.println(ans);
		kb.close();
	}
}

