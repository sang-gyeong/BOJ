import java.util.*;
public class BOJ7576 {
	public static final int [] dx = {0,0,1,-1};
	public static final int [] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); //순서 조심!!!
		int n = sc.nextInt();
		int [][] a = new int [n][m];
		int [][] dist = new int[n][m];
		Queue <Pair> q = new LinkedList<Pair>();	
		sc.nextLine();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
				dist[i][j] = -1; //-1 : 아직 방문안함 
				if (a[i][j] == 1) {
					q.add(new Pair(i,j)); //주어진 값이 1이면 q에 push***중요!! 
					dist[i][j]=0; //0 : 1을 가진 곳. 
				}
			}
		}
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x= p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0<=nx && nx < n && 0<=ny && ny<m) {
					if (a[nx][ny]==0 && dist[nx][ny]==-1) {
						q.add(new Pair(nx,ny));
						dist[nx][ny] = dist[x][y]+1;
					}
				}
			}
		}
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (ans < dist[i][j]) {
					ans = dist[i][j];
				}
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (a[i][j]==0 && dist[i][j]==-1) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}