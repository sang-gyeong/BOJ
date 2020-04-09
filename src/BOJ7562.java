import java.util.*;
public class BOJ7562 {
	public static final int [] dx = {2,1,-1,-2,2,1,-1,-2};
	public static final int [] dy = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int l = sc.nextInt();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			int [][] d = new int [l][l];
			for (int i=0; i<l; i++) {
				Arrays.fill(d[i],-1);
			}
			Queue <Pair> q = new LinkedList<>();
			q.add(new Pair(sx,sy));
			d[sx][sy]=0;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for (int k=0; k<8; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (0<=nx && nx<l && 0<=ny && ny<l) {
						if (d[nx][ny]==-1) {
							d[nx][ny] = d[x][y] + 1;
							q.add(new Pair(nx,ny));
						}
					}
				}
			}
			System.out.println(d[ex][ey]);
		}
	}
}

