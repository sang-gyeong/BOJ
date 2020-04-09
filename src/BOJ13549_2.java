import java.util.*;
public class BOJ13549_2 { //덱 코드 
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean [] c = new boolean [MAX];
		int [] d = new int [MAX];
		c[n]=true;
		d[n]=0;
		ArrayDeque <Integer> q = new ArrayDeque<>();
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int next : new int [] {now*2, now-1, now+1}) {
				if (next>=0 && next<MAX) {
					if(c[next]==false) {
						c[next]=true;
						if (now * 2 == next) {
							q.addFirst(next);
							d[next] = d[now];
						}
						else {
							q.addLast(next);
							d[next] = d[now] + 1;
						}
					}
				}
			}
		}
		System.out.println(d[m]);
	}	
}


