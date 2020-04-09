import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Pairs{
	Pair x;
	Pair y;
	Pairs(Pair x, Pair y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ13460 {
	static int gx;
	static int gy;
	static char [][] a = new char [12][12];

	static boolean cantmove(int bx, int by, int rx, int ry, int dir) {//움직일 수 있는 방향인지 확인 
		if(dir==0) {
			if(a[bx-1][by]=='#' && a[rx-1][ry]=='#') {
				return true;
			}
		}else if(dir==1) {
			if(a[bx][by+1]=='#' && a[rx][ry+1]=='#') {
				return true;
			}
		}else if(dir==2) {
			if(a[bx+1][by]=='#' && a[rx+1][ry]=='#') {
				return true;
			}
		}else if(dir==3) {
			if(a[bx][by-1]=='#' && a[rx][ry-1]=='#') {
				return true;
			}
		}
		return false;
	}

	static void move(int bx, int by, int rx, int ry, int dir) {//움직이기 
		int countb = 0;
		int countr = 0;
		if (dir==0) {//위 
			while(a[bx-1][by]!='#') {
				countb++;
			}
			while(a[rx-1][ry]!='#') {
				countr++;
			}
			bx-=countb;
			rx-=countr;
			if (bx==rx && by == ry) {//겹치는 경우 조정하기 
				if(countb>countr) {
					bx+=1;
				}else if (countb<countr) {
					rx+=1;
				}
			}
		}else if(dir==1) {//오른쪽 
			while(a[bx][by+1]!='#') {
				countb++;
			}
			while(a[rx][ry+1]!='#') {
				countr++;
			}
			by+=countb;
			ry+=countr;
			if (bx==rx && by == ry) {//겹치는 경우 조정하기 
				if(countb>countr) {
					by-=1;
				}else if (countb<countr) {
					ry-=1;
				}
			}
		}
		else if(dir==2) {//아래 
			while(a[bx+1][by]!='#') {
				countb++;
			}
			while(a[rx+1][ry]!='#') {
				countr++;
			}
			bx+=countb;
			rx+=countr;
			if (bx==rx && by == ry) {//겹치는 경우 조정하기 
				if(countb>countr) {
					bx-=1;
				}else if (countb<countr) {
					rx-=1;
				}
			}
		}
		else if(dir==3) {//왼쪽 
			while(a[bx][by-1]!='#') {
				countb++;
			}
			while(a[rx][ry-1]!='#') {
				countr++;
			}
			by-=countb;
			ry-=countr;
			if (bx==rx && by == ry) {//겹치는 경우 조정하기 
				if(countb>countr) {
					by+=1;
				}else if (countb<countr) {
					ry+=1;
				}
			}
		}
		System.out.println(bx +" " + by + " " + rx + " " + ry);
	}

	static int [][][][] ans = new int [11][11][11][11];
	static boolean [][][][] check = new boolean [11][11][11][11];
	static ArrayList<Integer> answer;
	static void bfs(int bx, int by, int rx, int ry) {
		Queue <Pairs> q = new LinkedList<>();
		check[bx][by][rx][ry]=true;
		ans[bx][by][rx][ry]=0;
		q.add(new Pairs(new Pair(bx, by), new Pair(rx, ry)));
		while(!q.isEmpty()) {
			Pairs p = q.poll();
			int bi = p.x.x;
			int bj = p.x.y;
			int ri = p.y.x;
			int rj = p.y.y;
			for (int dir=0; dir<4; dir++) {
				if(!cantmove(bi,bj,ri,rj,dir)) {
					System.out.println("can move");
					int a=bi;
					int b=bj;
					int c=ri;
					int d=rj;
					move(a,b,c,d,dir);
					if(check[a][b][c][d]==false) {
						if(a==gx && b==gy) {//파란구슬이 구멍에 빠진경우 
							continue;
						}
						if(c==gx && d==gy) {
							answer.add(ans[bi][bj][ri][rj]+1);
						}
						ans[a][b][c][d] = ans[bi][bj][ri][rj]+1;
						q.add(new Pairs(new Pair(a, b), new Pair(c, d)));
						check[a][b][c][d]=true;
					}
				}
			}
		}
	}


public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	int n=kb.nextInt();
	int m=kb.nextInt();
	int bx = 0;
	int by = 0;
	int rx = 0;
	int ry = 0;
	answer = new ArrayList<Integer>();
	a = new char[n][m];
	for (int i=0; i<n; i++) {
		String s = kb.next();
		for(int j=0; j<m; j++) {
			a[i][j]= s.charAt(j);
			if(a[i][j]=='B') {
				bx=i;
				by=j;
			}else if(a[i][j]=='R') {
				rx=i;
				ry=j;
			}else if(a[i][j]=='0') {
				gx=i;
				gy=j;
			}
		}
	}
	bfs(bx, by, rx, ry);
	if (answer.isEmpty()) {
		System.out.println(-1);
	}
	else {
		System.out.println(answer.get(0));
//		int min = 11;
//		for (int i=0; i<answer.size(); i++) {
//			if (min>answer.get(i)) {
//				min=answer.get(i);
//			}
//		}
//		if (min>10) System.out.println(-1);
//		else System.out.println(min);
	}

}

}
