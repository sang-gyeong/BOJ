import java.util.*;

public class BOJ17070 { //파이프 옮기기 1 
	static int n;
	static int answer = 0;
	static int [][] a = new int [18][18];
	static void go(int x, int y, int dir) {
		if(!(x>=0 && x<n && y>=0 && y<n && dir>=0 && dir<=2)) return;
		if(a[x][y]==1) return;
		if (x==n-1 && y==n-1) {
			answer++;
			return;
		}
		if(dir==0) {
			if (a[x][y+1]!=1) go(x, y+1, 0);
			if (a[x][y+1]!=1 && a[x+1][y]!=1 && a[x+1][y+1]!=1) go(x+1, y+1, 2);
		}else if(dir==1) {
			if (a[x+1][y]!=1) go(x+1, y, 1);
			if (a[x][y+1]!=1 && a[x+1][y]!=1 && a[x+1][y+1]!=1) go(x+1, y+1, 2);
		}else if(dir==2) {
			if (a[x][y+1]!=1) go(x, y+1, 0);
			if (a[x+1][y]!=1) go(x+1, y, 1);
			if (a[x][y+1]!=1 && a[x+1][y]!=1 && a[x+1][y+1]!=1) go(x+1, y+1, 2);
		}
	}
	
	public static void main(String[] args) {
		answer = 0;
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		go(0,1,0);
		System.out.println(answer);
	}
}
