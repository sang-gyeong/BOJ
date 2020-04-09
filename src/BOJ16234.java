import java.util.*;
public class BOJ16234 {
	static final int [] dx = {0,0,1,-1};
	static final int [] dy = {1,-1,0,0};
	static int [][] a = new int [101][101];
	static int [][] d = new int [101][101];
	static boolean [][] check = new boolean [101][101];
	static int n;
	static int l;
	static int r;
	static int answer;
	static boolean notfinish = false;

	public static void move(int tmp) {//인구교류 
		System.out.println("y");
		int sum=0;
		int c = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (d[i][j]==tmp) {
					sum+=a[i][j];
					c+=1;
				}
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (d[i][j]==tmp) {
					a[i][j] = (int)(sum/c);
				}
			}
		}
	}

	public static void bfs() {
		notfinish = false;
		Queue <Pair> q = new LinkedList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				check[i][j] = false;
				d[i][j] = 0;
			}
		}
		int tmp = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (check[i][j]==false) {
					q.add(new Pair(i,j));
					check[i][j] = true;
					d[i][j] = tmp++;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						for (int k=0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if (nx>=0 && nx<n && ny>=0 && ny<n) {
								if (check[nx][ny]==false && Math.abs(a[nx][ny]-a[x][y])>=l && Math.abs(a[nx][ny]-a[x][y])<=r)  {
									notfinish = true;
									check[nx][ny] = true;
									d[nx][ny] = d[x][y];
									q.add(new Pair(nx,ny));
								}
							}
						}
					}
					move(tmp);
				}
			}
		}
		for (int i=0; i<n; i++)
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		l = kb.nextInt();
		r = kb.nextInt();
		a = new int [n][n];
		d = new int [n][n];
		check = new boolean [n][n];

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		
		bfs();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
		
		while(true) {
			bfs();
			if (!notfinish) break;
			else answer++;
		}
		System.out.println(answer);
	}
}
