import java.util.*;
public class BOJ15653 {

	static int n;
	static int m;
	static int gx;
	static int gy;
	static char [][] a = new char [12][12];
	static int [][][][]balls = new int [12][12][12][12]; //빨강xy파랑xy 
	static int answer =0;
	
	static void copy(int copyrx, int copyry, int copybx, int copyby, int rx, int ry, int bx, int by) {
		copyrx=rx;
		copyry=ry;
		copybx=bx;
		copyby=by;
	}
	
	static void go(int rx, int ry, int bx, int by, int move) {
		int copyrx=0;
		int copyry=0;
		int copybx=0;
		int copyby=0;
		
		copy(copyrx, copyry, copybx, copyby, rx, ry, bx, by);
		left(copyrx,copyry,copybx,copyby);
		if (copyrx==gx && copyry==gy) {System.out.println(move+1);return;}
		if (copyrx!=rx || copyry!=ry || copybx!=bx || copyby!=by) {
			go(copyrx, copyry, copybx, copyby, move+1);
		}else {
			go(copyrx, copyry, copybx, copyby, move);
		}
		copy(copyrx, copyry, copybx, copyby, rx, ry, bx, by);
		right(copyrx,copyry,copybx,copyby);
		if (copyrx==gx && copyry==gy){System.out.println(move+1);return;}
		if (copyrx!=rx || copyry!=ry || copybx!=bx || copyby!=by) {
			go(copyrx, copyry, copybx, copyby, move+1);
		}else {
			go(copyrx, copyry, copybx, copyby, move);
		}
		copy(copyrx, copyry, copybx, copyby, rx, ry, bx, by);
		up(copyrx,copyry,copybx,copyby);
		if (copyrx==gx && copyry==gy){System.out.println(move+1);return;}
		if (copyrx!=rx || copyry!=ry || copybx!=bx || copyby!=by) {
			go(copyrx, copyry, copybx, copyby, move+1);
		}else {
			go(copyrx, copyry, copybx, copyby, move);
		}
		copy(copyrx, copyry, copybx, copyby, rx, ry, bx, by);
		down(copyrx,copyry,copybx,copyby);
		if (copyrx==gx && copyry==gy){System.out.println(move+1);return;}
		if (copyrx!=rx || copyry!=ry || copybx!=bx || copyby!=by) {
			go(copyrx, copyry, copybx, copyby, move+1);
		}else {
			go(copyrx, copyry, copybx, copyby, move);
		}
		
	}
	
	static void left(int rx, int ry, int bx, int by) {
		int cntr=0;
		int cntb=0;
		for (int j=ry-1; j>=0; j--) {
			if (a[rx][j]!='#') {
				ry=j;
				cntr++;
			}
			else break;
		}
		for (int j=by-1; j>=0; j--) {
			if (a[bx][j]!='#') {
				by=j;
				cntb++;
			}
			else break;
		}
		if (ry==by && rx==bx) {
			if(cntr>cntb) {
				ry=by+1;
			}
			else if(cntr<cntb) {
				by=ry+1;
			}
		}
		if (cntr!=0 || cntb!=0) {
			answer++;
		}
	}
	static void right(int rx, int ry, int bx, int by) {
		int cntr=0;
		int cntb=0;
		for (int j=ry+1; j<=m-1; j++) {
			if (a[rx][j]!='#') {
				cntr++;
				ry=j;
			}
			else break;
		}
		for (int j=by+1; j<=m-1; j++) {
			if (a[bx][j]!='#') {
				cntb++;
				by=j;
			}
			else break;
		}
		if (ry==by && rx==bx) {
			if(cntr>cntb) {
				ry=by-1;
			}
			else if(cntr<cntb) {
				by=ry-1;
			}
		}
		if (cntr!=0 || cntb!=0) {
			answer++;
		}
	}
	static void up(int rx, int ry, int bx, int by) {
		int cntr=0;
		int cntb=0;
		for (int i=rx-1; i>=0; i--) {
			if (a[i][ry]!='#') {
				cntr++;
				rx=i;
			}
			else break;
		}
		for (int i=bx-1; i>=0; i--) {
			if (a[i][by]!='#') {
				cntb++;
				bx=i;
			}
			else break;
		}
		if (ry==by && rx==bx) {
			if(cntr>cntb) {
				rx=bx+1;
			}
			else if(cntr<cntb) {
				bx=rx+1;
			}
		}
		if (cntr!=0 || cntb!=0) {
			answer++;
		}
	}
	static void down(int rx, int ry, int bx, int by) {
		int cntr=0;
		int cntb=0;
		for (int i=rx+1; i<=n-1; i++) {
			if (a[i][ry]!='#'){
				cntr++;
				rx=i;
			}
			else break;
		}
		for (int i=bx+1; i<=n-1; i++) {
			if (a[i][by]!='#') {
				cntb++;
				bx=i;
			}
			else break;
		}
		if (ry==by && rx==bx) {
			if(cntr>cntb) {
				rx=bx-1;
			}
			else if(cntr<cntb) {
				bx=rx-1;
			}
		}
		if (cntr!=0 || cntb!=0) {
			answer++;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int rx=0;
		int ry=0;
		int bx=0;
		int by=0;
		n = kb.nextInt();
		m = kb.nextInt();
		a = new char [n][m];
		balls = new int [n][m][n][m];
		for (int i=0; i<n; i++) {
			String s = kb.next();
			for (int j=0; j<m; j++) {
				a[i][j]=s.charAt(j);
				if (a[i][j]=='0') {
					gx=i;
					gy=j;
				}else if (a[i][j]=='R') {
					rx=i;
					ry=j;
					
				}else if (a[i][j]=='B') {
					bx=i;
					by=j;
				}
			}
		}
		go(rx,ry,bx,by,0);
	}

}
