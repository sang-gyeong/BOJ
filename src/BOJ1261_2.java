import java.util.*;
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ1261_2 { //덱코드 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int [][] a = new int [n][m];
		for (int i=0; i<n; i++) {
			String s = sc.nextLine();
			for (int j=0; j<m; j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
		int [] dx = {0,0,1,-1};
		int [] dy = {1,-1,0,0};
		int [][] d = new int [n][m];
		ArrayDeque <Pair> q = new ArrayDeque<Pair>();
		q.add(new Pair(0,0));
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				d[i][j] = -1;
			}
		}
		d[0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0<=nx && nx<n && 0<=ny && ny<m) {
					if (d[nx][ny]==-1) {
						if (a[nx][ny]==0) {
							d[nx][ny] = d[x][y];
							q.addFirst(new Pair(nx,ny));
						}else {
							d[nx][ny] = d[x][y]+1;
							q.addLast(new Pair(nx,ny));
						}
					}
				}
			}
		}
		System.out.println(d[n-1][m-1]);
	}
}
