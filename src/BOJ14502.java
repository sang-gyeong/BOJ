import java.util.*;
public class BOJ14502 {
	static int n;
	static int m;
	static int answer = 0;
	static final int [] dx = {0,0,1,-1};
	static final int [] dy = {1,-1,0,0};
	static int [][] a = new int [9][9];
	static int [][] map = new int [9][9];	

	public static void cloneMap() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				map[i][j] = a[i][j];
			}
		}
	}

	static void virus() {//바이러스 퍼뜨리기 
		int [][] temp = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				temp[i][j]=map[i][j];
			}
		}
		Queue <Pair> q = new LinkedList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (temp[i][j]==2) {
					q.add(new Pair(i,j));
				}
			}
		}//bfs시 주의할점)이중포문 닫아준 뒤에 while문 실행해주기!

		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if (nx>=0 && nx<=n-1 && ny>=0 && ny<=m-1 && temp[nx][ny]==0) {
					temp[nx][ny]=2;
					q.add(new Pair(nx,ny));

				}
			}
		}			
		int cnt=0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (temp[i][j]==0) {
					cnt++;
				}
			}
		}
		if (cnt>answer) answer = cnt;
	}

	//3개 세우기 
	public static void go(int cnt) {
		if (cnt==3) {
			virus();
			return;
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(map[i][j]==1 || map[i][j]==2) continue;
				map[i][j]=1;
				go(cnt+1);
				map[i][j]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j]=kb.nextInt();
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (a[i][j]==2 || a[i][j]==1) continue;
				cloneMap();
				map[i][j]=1;
				go(1);
				map[i][j]=0;
			}
		}

		System.out.println(answer);
		kb.close();

	}

}
