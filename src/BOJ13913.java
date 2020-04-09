import java.util.*;
public class BOJ13913 {
	static void go(int[]from, int n, int m) {
		if (n!=m) {
			go(from,n,from[m]);
		}
		System.out.print(m+" ");
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int [] dist = new int [100001];
		boolean [] check = new boolean [100001];
		int [] from = new int [100001];
		Queue <Integer> q = new LinkedList<>();
		check[n] = true;
		dist[n] = 0;
		q.add(n);
		while(!q.isEmpty()) {
			int m = q.remove();
			if (m-1>=0) {
				if (check[m-1]==false) {
					check[m-1]=true;
					q.add(m-1);
					dist[m-1] = dist[m]+1;
					from[m-1] = m;
				}
			}
			if (m+1<=100000) {
				if (check[m+1]==false) {
					check[m+1]=true;
					q.add(m+1);
					dist[m+1] = dist[m]+1;
					from[m+1] = m;
				}
			}
			if (m*2<=100000) {
				if (check[m*2]==false) {
					check[m*2]=true;
					q.add(m*2);
					dist[m*2] = dist[m]+1;
					from[m*2] = m;
				}
			}
		}
		System.out.println(dist[k]);
		go(from,n,k);
		
		//<<<< Print with Stack >>>>
		//		Stack <Integer> ans = new Stack<>();
		//		for (int i=k; i!=n; i=from[i]) {
		//			ans.push(i);
		//		}
		//		ans.push(n);
		//		while(!ans.isEmpty()) {
		//			System.out.print(ans.pop() +" ");
	}
}

