import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ17144 { //미세먼지 안녕!
	//bfs보다는 시뮬레이션에 더 가까운 것 같다
	//while문을 사용해서품 
	static final int [] dx = {0,0,1,-1};
	static final int [] dy = {1,-1,0,0};
	static int n;
	static int m;
	static int t;
	static int up;
	static int down;
	static List<Pair> list;
	static int [][] a = new int [53][53]; //미세먼지 근원지 
	static int [][] b = new int [53][53]; //날리는 미세먼지 


	static void spread() { //미세먼지 확산 
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(a[i][j]>0) {
					int tmp = 0;
					for (int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && nx<n && ny>=0 && ny<m) {
							if(a[nx][ny]!=-1) {
								tmp++;
								b[nx][ny]+=a[i][j]/5;
							}
						}
					}
					a[i][j]-=((a[i][j]/5)*tmp);
				}
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j]+= b[i][j];
				b[i][j]=0;
			}
		}
	}

	static void refup() { //공기청정기 위쪽 작동 
		int x = list.get(0).x-1;
		int y = list.get(0).y;
		a[x][y]=0;
		while(true) { 			
			if(x!=0 && y==0) { //왼쪽벽 
				int tmp = a[x][y];
				a[x][y] = a[x-1][y];
				a[x-1][y] = tmp;
				x-=1;
			}
			else if(x==0 && y!=m-1) { //천장 
				int tmp = a[x][y];
				a[x][y] = a[x][y+1];
				a[x][y+1] = tmp;
				y+=1;
			}
			else if(x!=list.get(0).x && y==m-1) { //오른쪽 벽 
				int tmp = a[x][y];
				a[x][y] = a[x+1][y];
				a[x+1][y] = tmp;
				x+=1;
			}
			else if(x==list.get(0).x && y>list.get(0).y+1) { //에어컨 오른쪽 
				int tmp = a[x][y];
				a[x][y] = a[x][y-1];
				a[x][y-1] = tmp;
				y-=1;
			}
			else if(x==list.get(0).x && y==list.get(0).y+1) {//도착 
				return;
			}
		}
	}
	static void refdown() { //공기청정기 아랫부분 작동 
		int x = list.get(1).x + 1;
		int y = list.get(1).y;
		a[x][y]=0;
		while(true) { 			
			if(x!=n-1 && y==0) { //왼쪽벽 
				int tmp = a[x][y];
				a[x][y] = a[x+1][y];
				a[x+1][y] = tmp;
				x+=1;
			}
			else if(x==n-1 && y!=m-1) { //아래벽 
				int tmp = a[x][y];
				a[x][y] = a[x][y+1];
				a[x][y+1] = tmp;
				y+=1;
			}
			else if(x!=list.get(1).x && y==m-1) { //오른쪽 벽 
				int tmp = a[x][y];
				a[x][y] = a[x-1][y];
				a[x-1][y] = tmp;
				x-=1;
			}
			else if(x==list.get(1).x && y>list.get(1).y+1) { //에어컨 오른쪽 
				int tmp = a[x][y];
				a[x][y] = a[x][y-1];
				a[x][y-1] = tmp;
				y-=1;
			}
			else if(x==list.get(1).x && y==list.get(1).y+1) {//도착 
				return;
			}
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		t = kb.nextInt();
		a = new int [n][m];
		b = new int [n][m];
		int sum=0;
		list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j] = kb.nextInt();
				if (a[i][j]==-1) { //냉장고 위치 저장 
					list.add(new Pair(i,j));
				}
			}
		}
		int tmp=0;
		while(tmp!=t) { 
			spread();
			refup();
			refdown();
			tmp++;
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(a[i][j]>0) {
					sum+=a[i][j];
				}
			}
		}
		System.out.println(sum);
	}
}
