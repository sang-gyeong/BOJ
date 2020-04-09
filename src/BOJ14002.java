import java.util.*;
public class BOJ14002 {
	
	static int []a;
	static int []d;
	static int []v;
	
	static void go(int p) {
		if (p==-1) return;
		go(v[p]);
		System.out.print(a[p]+" ");
	}
	
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		a = new int [n+1];
		d = new int [n+1];
		v = new int [n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = kb.nextInt();
		}

		for (int i=1; i<=n; i++) {
			d[i] = 1;
			v[i] = -1;
			for (int j=i-1; j>=1; j--) {
				if (a[j] < a[i]&&d[i]<d[j]+1) {
					d[i]=d[j]+1;
					v[i] = j;
				}
			}	
		}
		int max=d[0];
		int p=0;
		for (int i=1; i<=n; i++) {
			if (d[i]>max) {
				max = d[i];
				p=i;
			}
		}
		System.out.println(max);
		go(p);
		kb.close();
	}
}
