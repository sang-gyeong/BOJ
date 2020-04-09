import java.util.*;
public class BOJ1697 {
	static boolean [] check = new boolean [100001];
	static int [] d = new int [100001];
	static int n;
	static int k;
	static void bfs() {
		Queue <Integer> q = new LinkedList<>();
		check[n]=true;
		d[n] = 0;
		q.add(n);
		while(!q.isEmpty()) {
			int x = q.poll();
			if (x-1>=0) {
				if (check[x-1]==false) {
					q.add(x-1);
					check[x-1] = true;
					d[x-1] = d[x]+1;
				}
			}
			if (x+1<=100000) {
				if (check[x+1]==false) {
					q.add(x+1);
					check[x+1] = true;
					d[x+1] = d[x]+1;
				}
			}
			if(x*2<=100000) {
				if (check[x*2]==false) {
					q.add(x*2);
					check[x*2] = true;
					d[x*2] = d[x]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		k = kb.nextInt();
		bfs();
		System.out.println(d[k]);
	}
}
