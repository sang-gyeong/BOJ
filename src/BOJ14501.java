import java.util.*;
public class BOJ14501 {
	static int [] t;
	static int [] p;
	static int n;
	static int ans = 0;
	static void go(int day, int money) { 
		if (day ==n+1) {
			if (ans<money) ans = money;
			return;
		}
		if (day>n+1) {
			return;
		}
		go(day+1, money);
		go(day+t[day], money+p[day]);	
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		t = new int [n+1];
		p = new int [n+1];
		for (int i=1; i<=n; i++) {
			t[i] = kb.nextInt();
			p[i] = kb.nextInt();
		}
		go(1,0);
		System.out.println(ans);
	}
}

