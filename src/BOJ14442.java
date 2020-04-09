import java.util.*;
//
//class Pair{
//	int x;
//	int y;
//	Pair(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
public class BOJ14442 { //벽부수고 이동하기2 
	static final int [] dx = {0,0,1,-1};
	static final int [] dy = {1,-1,0,0};
	static int n;
	static int m;
	static int [][] a = new int [1111][1111];
	static int [][] d = new int [1111][1111];
	static boolean [][] check = new boolean [1111][1111];
	static int [][] c = new int [1111][1111];
	static int k;
	static List <Integer> list = new ArrayList<>();;

	
	
	static void bfs(int count) { //count(부술 수 있는 횟수) 1부터 시작 
		for (int i=0; i<n; i++) { //초기화 
			Arrays.fill(d[i], 0);
			Arrays.fill(c[i], 0);
			Arrays.fill(check[i], false);
		}
		Queue <Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		check[0][0] = true;
		c[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(check[nx][ny]==false) {
						if(a[nx][ny]==1 && d[x][y]+1 <=count) { //1 
							check[nx][ny]=true;
							d[nx][ny]= d[x][y]+1;
							c[nx][ny]= c[x][y]+1;
							q.add(new Pair(nx,ny));
						}else if(a[nx][ny]==0 && d[x][y]<=count){ //0 
							check[nx][ny]=true;
							d[nx][ny] = d[x][y]; 
							c[nx][ny] = c[x][y]+1;
							q.add(new Pair(nx,ny));
						}
					}
				}
			}
		}
		if (check[n-1][m-1] && c[n-1][m-1]!=0) {
			list.add(c[n-1][m-1]);//도착점에 도달했을경우 list에 이동횟수 add 
		}			
	}


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		list = new ArrayList<>();
		n = kb.nextInt();
		m = kb.nextInt();
		k = kb.nextInt();
		a = new int [n][m];
		d= new int [n][m];
		c = new int [n][m];
		check = new boolean [n][m];
		for (int i=0; i<n; i++) {
			String input = kb.next();
			for (int j=0; j<m; j++) {
				a[i][j] = input.charAt(j)-'0';
			}
		}	
		bfs(k);
		
		if (list.isEmpty()) {
			System.out.println(-1);
		}else {
			int min = 987654321;
			for (int i=0; i<list.size(); i++) {
				if (min>list.get(i)) {
					min = list.get(i);
				}
			}
			System.out.println(min);  
		}
	}
}
