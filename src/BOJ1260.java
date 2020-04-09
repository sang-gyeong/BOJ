import java.util.*;
public class BOJ1260 {
	static ArrayList<Integer>[] a; //인접리스트
	static boolean[]c;
	
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x]=true;
		System.out.print(x+" ");
		for (int y : a[x]) {
			if (c[y]==false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue <Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start]=true;
		while(!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x + " ");
			for (int y : a[x]) {
				if (c[y]==false) {
					c[y]=true;
					q.add(y);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int start = kb.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i=1; i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int u = kb.nextInt();
			int v = kb.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		for (int i=1;i<=n; i++) { //정렬 
			Collections.sort(a[i]);
		}
		
		c=new boolean[n+1];
		dfs(start);
		System.out.println();
		c=new boolean[n+1];
		bfs(start);
		System.out.println();

	}
}





