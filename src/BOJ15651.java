import java.util.*;
public class BOJ15651 {
	
	static int[]a = new int[10];
	static boolean[]c = new boolean[10];
	static StringBuilder go(int index, int n, int m) {
		StringBuilder sb = new StringBuilder();
		if (index==m) {
			for (int i=0; i<m; i++) {
				sb.append(a[i]);
				if(i!=m-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return sb;
		}
		StringBuilder ans = new StringBuilder();
		for (int i=1; i<=n; i++) {
			a[index]=i;
			ans.append(go(index+1, n, m));
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		System.out.print(go(0,n,m));

	}

}
