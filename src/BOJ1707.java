import java.util.*;
public class BOJ1707 {

	public static void dfs(ArrayList<Integer>[]a, int[]color, int x, int c) {
		color[x] = c;
		for (int y: a[x]) {
			if (color[y]==0) {
				dfs(a, color, y, 3-c);
			}
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int k = kb.nextInt();
		while (k-- > 0) {
			int n = kb.nextInt();
			int m = kb.nextInt();
			ArrayList<Integer> [] a = (ArrayList<Integer>[]) new ArrayList[n+1];

			for (int i=1; i<=n; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for (int i=0; i<m; i++) {
				int u = kb.nextInt();
				int v = kb.nextInt();
				a[u].add(v);
				a[v].add(u);
			}
			int [] color = new int[n+1];
			boolean ok = true;
			for (int i=1; i<=n; i++) {
				if (color[i]==0) {
					dfs(a,color, i, 1);
				}
			}
			for (int i=1; i<=n; i++) {
				for (int j: a[i]) {
					if (color[i]==color[j]) {
						ok = false;
					}
				}
			}
			if (ok) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
