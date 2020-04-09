import java.util.*;

public class BOJ2667_DFS {
	public static final int [] dx= {0,0,1,-1};
	public static final int [] dy= {1,-1,0,0};
	public static void dfs(int [][]a, int [][]group, int x, int y, int cnt, int n) {
		group[x][y]=cnt;
		for (int k=0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if (0<=nx && nx<n && 0<=ny && ny<n) {		//좌표범위 벗어나나 체크 
				if(a[nx][ny]==1 && group[nx][ny]==0) { //가구 존재 && 방문하지않음 
					dfs(a,group,nx,ny,cnt,n);
				}
			}
		}
	}
public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	int n = kb.nextInt();
	kb.nextLine();
	int [][]a = new int [n][n];
	for (int i=0; i<n; i++) { 			//입력 
		String s = kb.nextLine();
		for (int j=0; j<n; j++) {
			a[i][j]=s.charAt(j)-'0';
		}
	}
	int cnt =0;
	int [][]group = new int [n][n];
	for (int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			if (a[i][j]==1 && group[i][j]==0) {
				dfs(a,group,i,j,++cnt,n); //++cnt에 주목 
			}
		}
	}
	int [] ans = new int[cnt];
	for (int i=0; i<n; i++) {
		for (int j=0; j<n; j++) {
			if (group[i][j]!=0) {
				ans[group[i][j]-1]+=1;
			}
		}
	}

	Arrays.sort(ans);
	System.out.println(cnt);
	for(int i=0; i<cnt; i++) {
		System.out.println(ans[i]);
	}
	kb.close();
}
}
