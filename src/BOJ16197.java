import java.util.*;

class Coin{
	int x;
	int y;
	Coin (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ16197 {

	static int n;
	static int m;
	static int answer = 20;
	
	
	static boolean check(char[]a, int ax, int ay, int bx, int by) {
		if (ax>=0 && ax<n && ay>=0 && ay<m && bx>=0 && bx<n && by>=0 && by<m) {
			return false;
		}else if ((ax<0 || ax>=n || ay<0 || ay>=m) && (bx<0 || bx>=n || by<0 || by>=m))  {
			return false;
		}else {
			return true;
		}
	}
	
	static void go(char[]a, int ax, int ay, int bx, int by, int push) {
		if(push>10) return;
		if (check(a,ax,ay,bx,by)) {
			if (answer > push) answer = push;
			return;
		}
	
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		
		char [][] a = new char [n][m];
		
		int ax = -1;
		int ay = -1;
		int bx = -1;
		int by = -1;
		int push = 0;

		
		for (int i=0; i<n; i++) {
			String s = kb.next();
			for (int j=0; j<m; j++) {
				a[i][j] = s.charAt(j);
				if (s.charAt(j)=='o') {
					a[i][j] = '.';
					if(ax==-1 && ay==-1) {
						ax = i;
						ay = j;
					}else {
						bx = i;
						by = j;
					}
				}
			}
		}
		
		
		
		
		

	}

}
