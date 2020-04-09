import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ3055 {
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


	public static void go() {//고슴도치 이동 
		Queue <Pair> q = new LinkedList<>();
		for (int i=0; i<r; i++) {
			Arrays.fill(d[i],-1);
		}
		q.add(new Pair(x,y));
		d[x][y]=0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if (nx>=0 && nx<=r-1 && ny>=0 && ny<=c-1) {
					if( d[nx][ny]==-1 && a[nx][ny]=='.'&& d[x][y]+1<water[nx][ny]){
						d[nx][ny]=d[x][y]+1;
						q.add(new Pair(nx,ny));
					}else if (d[nx][ny]==-1 && a[nx][ny]=='D') {
						d[nx][ny]=d[x][y]+1;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
	}


	public static void water() {//물 이동 
		Queue <Pair> q = new LinkedList<>();
		for (int i=0; i<r; i++) {
			Arrays.fill(water[i],-1);
		}
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (a[i][j]=='*') {
					q.add(new Pair(i,j));
					water[i][j]=0;
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if (nx>=0 && nx<=r-1 && ny>=0 && ny<=c-1) {
					if(water[nx][ny]==-1 && (a[nx][ny]=='.'||a[nx][ny]=='S')) {
						water[nx][ny]=water[x][y]+1;
						q.add(new Pair(nx,ny));
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
		water();
		go();
		
//		for (int i=0; i<r; i++) {
//			for (int j=0; j<c; j++) {
//				System.out.print(d[i][j]);
//			}
//			System.out.println();
//		}
//		for (int i=0; i<r; i++) {
//			for (int j=0; j<c; j++) {
//				System.out.print(water[i][j]);
//			}
//			System.out.println();
//		}
//		
		
		if(d[gx][gy]==-1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(d[gx][gy]);
		}
	}
}
