import java.util.*;
public class BOJ3055_2 {
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int r;
	static int c;
	static int gx;
	static int gy;
	static int x;
	static int y;
	static char [][] a = new char [51][51];
	static int [][] water = new int [51][51];//물 
	static int [][] d = new int [51][51];//고슴도치 


	public static void go() {
		for (int i=0; i<r; i++) {
			Arrays.fill(d[i], -1);
		}
		d[x][y]=0;
		Queue <Pair> q = new LinkedList<>();
		Queue <Pair> q1 = new LinkedList<>();
		q1.add(new Pair(x,y));
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if(a[i][j]=='*') {
					q.add(new Pair(i,j));
				}
			}
		}
		while(!q.isEmpty()&&!q1.isEmpty()) {
			Pair p = q.poll();
			int x=p.x;
			int y=p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<=r-1 && ny>=0 && ny<=c-1) {
					if(a[nx][ny]!='X' && a[nx][ny]!='D') {
						a[nx][ny]='*';
						q.add(new Pair(nx,ny));
					}
				}
			}
			p = q1.poll();
			x=p.x;
			y=p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<=r-1 && ny>=0 && ny<=c-1) {
					if (d[nx][ny]==-1 && a[nx][ny]!='X' && a[nx][ny]!='*') {
						d[nx][ny]= d[x][y]+1;
						q1.add(new Pair(nx,ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		r = kb.nextInt();
		c = kb.nextInt();
		a = new char [r][c];
		water = new int [r][c];
		d = new int [r][c];

		for (int i=0; i<r; i++) {
			String s = kb.next();
			for (int j=0; j<c; j++) {
				a[i][j] = s.charAt(j);
				if (a[i][j]=='D') {
					gx=i;
					gy=j;
				}else if(a[i][j]=='S') {
					x=i;
					y=j;
				}
			}
		}
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}

	}
}
