import java.util.*;
public class BOJ15649 {
	static boolean [] c = new boolean [10];
	static int [] a = new int [10];
	static void go(int index, int n, int m) {
		if (index==m) {
			for (int i=0; i<m; i++) {
				System.out.print(a[i]);
				if (i!=m-1) {
					System.out.print(' ');
				}
			}
			System.out.println();
			return;
		}
		for (int i=1; i<=n; i++) {
			if (c[i]) continue;
			c[i] = true;
			a[index] = i;
			go(index+1,n,m);
			c[i]=false;
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		go(0,n,m);
		kb.close();
	}
}