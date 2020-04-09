import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ4963 {
	public static final int [] nx = {0,0,1,-1,-1,-1,1,1};
	public static final int [] ny = {1,-1,0,0,-1,1,-1,1};
	public static void bfs (int [][]a, int[][]group, int x, int y, int cnt, int w, int h) {
		Queue <Pair> q = new LinkedList <Pair>();
		q.add(new Pair(x,y));
		group[x][y] = cnt;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			for (int k=0; k<8; k++) {
				int dx = x + nx[k];
				int dy = y + ny[k];
				if (0<=dx && dx<h && 0<=dy && dy<w) {
					if (a[dx][dy]==1 && group[dx][dy]==0) {
						q.add(new Pair(dx,dy));
						group[dx][dy]=cnt;
					}
				}
			}
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w==0 && h==0) break; //0 0 입력시 break 
			int [][] a = new int [h][w];

			for (int i=0; i<h; i++) { //입력 
				for (int j=0; j<w; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int [][] group = new int [h][w];
			int cnt = 0;
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if(a[i][j]==1 && group[i][j]==0) {
						bfs(a,group,i,j,++cnt,w,h);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
