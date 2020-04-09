import java.util.*;
public class BOJ14503 { //로봇 청소기 
	static int n;
	static int m;
	static int [][] a = new int [100][100];
	static boolean [][] b = new boolean [100][100];
	static int answer = 0;
	static void go(int r, int c, int dir, int count) {
		if (a[r][c]==0 && b[r][c]==false) {	//현재 위치 청소가능 : answer+1, false => true 
			answer++;
			b[r][c]=true;
		}
		if(count==4||((a[r-1][c]==1 || b[r-1][c]==true) && //네 면을 모두 탐색했거나, 네 면 모두 청소할 수 없는경우(이미 했거나 벽) 
				(a[r][c-1]==1 || b[r][c-1]==true) &&
				(a[r][c+1]==1 || b[r][c+1]==true) &&
				(a[r+1][c]==1 || b[r+1][c]==true))) { 
			if(dir==0) {
				if(a[r+1][c]==1) { //바로 뒤가벽이면 정지 / 아니라면 후진 
					return;
				}else {
					go(r+1, c, 0, 0);
				}
			}
			else if(dir==1) {
				if(a[r][c-1]==1) {
					return;
				}else {
					go(r, c-1, 1, 0);
				}
			}
			else if(dir==2) {
				if(a[r-1][c]==1) {
					return;
				}else {
					go(r-1, c, 2, 0);
				}
			}
			else if(dir==3) {
				if(a[r][c+1]==1) {
					return;
				}else {
					go(r, c+1, 3,0 );
				}
			}
		}else {	//네면을 모두 탐색하지 않은 경우
			if (dir==0) {
				if (a[r][c-1]!=1 && b[r][c-1]==false) { //이동 가능 : 방향전환&좌표이동&count초기화 
					go(r,c-1,3,0);
				}else {
					go(r,c,3,count++); 					//이동 불가능 : 방향전환&count+1 
				}
			}else if(dir==1) {
				if (a[r-1][c]!=1 && b[r-1][c]==false) {
					go(r-1,c,0,0);
				}else {
					go(r,c,0,count++);
				}
			}else if(dir==2) {
				if (a[r][c+1]!=1 && b[r][c+1]==false) {
					go(r,c+1,1,0);
				}else {
					go(r,c,1,count++);
				}
			}else if(dir==3) {
				if (a[r+1][c]!=1 && b[r+1][c]==false) {
					go(r+1,c,2,0);
				}else {
					go(r,c,2,count++);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		a = new int [n][m];
		b = new boolean [n][m];
		int r = kb.nextInt();
		int c = kb.nextInt();
		int dir = kb.nextInt();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j]=kb.nextInt();
			}
		}
		go(r,c,dir, 0);
		System.out.println(answer);
	}
}
