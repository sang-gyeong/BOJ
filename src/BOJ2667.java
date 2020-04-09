import java.util.*;
//class Pair{
//	int x;
//	int y;
//	Pair(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
public class BOJ2667 { //단지번호 붙이기 

	static final int [] dx = {0,0,1,-1};
	static final int [] dy = {1,-1,0,0};
	static int n;
	static int tmp;
	static int [][] a = new int [27][27];
	static int [][] d = new int [27][27];
	static boolean [][] check = new boolean [27][27];
	static List<Integer> list = new ArrayList<>();
	
	static void bfs() {
		Queue <Pair> q = new LinkedList<>();
		tmp = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(a[i][j]==1 && check[i][j]==false) {
					int count = 1; 		 //단지 수 
					tmp++;				//단지 번호 
					q.add(new Pair(i,j));
					check[i][j] = true;
					d[i][j] = tmp;
					while (!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						for (int k=0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && nx<n && ny>=0 && ny<n) {
								if (check[nx][ny]==false && a[nx][ny]==1) {
									d[nx][ny]=d[i][j];
									check[nx][ny]=true;
									q.add(new Pair(nx,ny));
									count++;
								}
							}
						}
						if(q.isEmpty())list.add(count);
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		a = new int [n][n];
		d = new int [n][n];
		check = new boolean [n][n];
		list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			String s = kb.next();
			for (int j=0; j<n; j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs();
		
		System.out.println(tmp); 
		Collections.sort(list);
		for (int i=0; i<list.size();i++) { //단지수 오름차순으로 출력  
			System.out.println(list.get(i));

		}
	}
}

