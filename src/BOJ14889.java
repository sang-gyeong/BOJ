import java.util.*;
public class BOJ14889 {
	static int n;
	static int [][] a;
	static int go(int i, ArrayList<Integer>start, ArrayList<Integer>link) {
		if (i==n) {
			if (start.size()!=n/2) return -1;
			if (link.size()!=n/2) return -1;
			int t1=0;
			int t2=0;
			for (int k=0; k<n/2; k++) {
				for (int j=0; j<n/2; j++) {
					if (k==j) continue;
					t1 += a[start.get(k)][start.get(j)];
					t2 += a[link.get(k)][link.get(j)];
				}
			}
			int diff = Math.abs(t1-t2);
			return diff;
		}
		//백트래킹
        if (start.size() > n/2) return -1;
        if (link.size() > n/2) return -1;
        
		int ans = -1;//i번째 선수가 1번째팀에들어가는 경우 
		start.add(i);
		int t1 = go(i+1, start, link);
		if (ans ==-1 || (t1 != -1 && ans>t1)) {
			ans = t1;
		}
		start.remove(start.size()-1); //다시 빼주기 

		link.add(i); //i번째 선수가 2번째팀에들어가는 경우 
		int t2 = go(i+1, start, link);
		if (ans==-1 || (t2 != -1 && ans>t2)) {
			ans = t2;
		}
		link.remove(link.size()-1);
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		a = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		ArrayList<Integer>start = new ArrayList<>();
		ArrayList<Integer>link = new ArrayList<>();
		System.out.println(go(0,start, link));
	}
}
