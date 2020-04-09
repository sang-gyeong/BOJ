import java.util.*;
class Ps{
	int r;
	int c;
	int s;
	Ps(int r, int c, int s){
		this.r = r;
		this.c = c;
		this.s = s;
	}
}
public class BOJ17406 { //배열돌리기 4 
	static ArrayList<Ps> list = new ArrayList<>();
	static ArrayList<Integer> mins = new ArrayList<>();
	static int n;
	static int m;
	static int k;
	static boolean [] orders = new boolean [k];
	static int [][] a = new int [52][52];
	public static int [][] turn(Ps p, int [][] arr) {
		int sx = p.r-p.s-1;
		int sy = p.c-p.s-1;
		int ex = p.r+p.s-1;
		int ey = p.c+p.s-1;
		int [][] c = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				c[i][j] = arr[i][j];
			}
		}
		while (sx!=ex && sy!=ey) {
			int tmp = c[sx][ey];
			for (int j=ey; j>=sy+1; j--) {
				c[sx][j] = c[sx][j-1];
			}
			int tmp2 = c[ex][ey];
			for (int i=ex; i>=sx+2; i--) {
				c[i][ey] = c[i-1][ey];
			}
			c[sx+1][ey] = tmp;
			tmp = c[ex][sy];
			for (int j=sy; j<=ey-2; j++) {
				c[ex][j] = c[ex][j+1];
			}
			c[ex][ey-1] = tmp2;
			for (int i=sx; i<=ex-2; i++) {
				c[i][sy] = c[i+1][sy];
			}
			c[ex-1][sy] = tmp;
			sx+=1;
			sy+=1;
			ex-=1;
			ey-=1;
		}
		return c;
	}
	
	public static void go(int [][] arr, int count) {
		if (count==k) {
			int answer = Integer.MAX_VALUE;
			for (int i=0; i<n; i++) {
				int sum = 0;
				for (int j=0; j<m; j++) {
					sum+=arr[i][j];
				}
				answer = Math.min(answer, sum);
			}
			mins.add(answer);
			return;
		}
		for (int i=0; i<list.size(); i++) {
			if (orders[i]==true) continue;
			orders[i]=true;
			go(turn(list.get(i), arr), count+1);
			orders[i]=false;
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		list = new ArrayList<>();
		mins = new ArrayList<>();
		n = kb.nextInt();
		m = kb.nextInt();
		k = kb.nextInt();
		a = new int [n][m];
		orders = new boolean [k];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		for (int i=0; i<k; i++) {
			int r = kb.nextInt();
			int c = kb.nextInt();
			int s = kb.nextInt();
			list.add(new Ps(r,c,s));
		}
		go(a, 0);
		int min = Integer.MAX_VALUE;
		for (int i=0; i<mins.size(); i++) {
			if (min>mins.get(i)) {
				min = mins.get(i);
			}	
		}
		System.out.println(min);
	}
}
