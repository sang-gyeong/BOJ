import java.util.*;
public class BOJ15683 {

	static int n;
	static int m;
	static int ans = n*m;
	static int [][] a = new int [10][10];
	static int [][] temp = new int [10][10];
	static List <Pair> cctv;
	static int answer = 100;

	static int count(int[][]d) {
		int cnt = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (d[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	

	
	static void go(int index, int [][]d) {
		if (index>cctv.size()) return;
		if (index==cctv.size()) {
			System.out.println(count(d));
			if (answer>count(d)) answer = count(d);
			System.out.println(count(d));
			return;
			
		}
		int what = a[cctv.get(index).x][cctv.get(index).y];
		int x = cctv.get(index).x;
		int y = cctv.get(index).y;

		if (what==1) {
			go(index+1,right(d,x,y));
			go(index+1,up(d,x,y));
			go(index+1,left(d,x,y));
			go(index+1,down(d,x,y));
		}else if(what==2) {
			go(index+1, right(left(d,x,y),x,y));
			go(index+1, down(up(d,x,y),x,y));
			
		}
	}


	static int[][] right(int[][]x, int a, int b) {//오른쪽 
		int [][] temp = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				temp[i][j]=x[i][j];
			}
		}
		for (int k=b+1; k<m; k++) {
			if(temp[a][k]==6) break;
			if(temp[a][k]!=0) continue;
			temp[a][k]='#';
		}
		return temp;
	}

	static int[][] left(int[][]x, int a, int b) {//왼쪽 
		int [][] temp = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				temp[i][j]=x[i][j];
			}
		}
		for (int k=b-1; k>=0; k--) {
			if(temp[a][k]==6) break;
			if(temp[a][k]!=0) continue;
			temp[a][k]='#';
		}
		return temp;
	}

	static int[][] up(int[][]x, int a, int b) {//위
		int [][] temp = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				temp[i][j]=x[i][j];
			}
		}
		for (int k=a-1; k>=0; k--) {
			if(temp[k][b]==6) break;
			if(temp[k][b]!=0) continue;
			temp[k][b]='#';
		}
		return temp;
	}
	static int[][] down(int[][]x, int a, int b) {//아래 
		int [][] temp = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				temp[i][j]=x[i][j];
			}
		}
		for (int k=a+1; k<n; k++) {
			if(temp[k][b]==6) break;
			if(temp[k][b]!=0) continue;
			temp[k][b]='#';
		}
		return temp;
	}




	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		List <Pair> cctv = new ArrayList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				a[i][j] = kb.nextInt();
				if(a[i][j]>=0 && a[i][j]<=5) {
					cctv.add(new Pair(i,j));
				}
			}
		}
		System.out.println(answer);

	}

}
