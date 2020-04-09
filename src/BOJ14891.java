import java.util.*;
public class BOJ14891 {//톱니바퀴 

	static void turn(int[][]d, int r, int dir) {//1: 시계 -1:반시계 
		if (dir==1) {
			int tmp = d[r][0];
			d[r][0] = d[r][7];
			d[r][7] = d[r][6];
			d[r][6] = d[r][5];
			d[r][5] = d[r][4];
			d[r][4] = d[r][3];
			d[r][3] = d[r][2];
			d[r][2] = d[r][1];
			d[r][1] = tmp;
		}
		else if (dir==-1){
			int tmp = d[r][0];
			d[r][0] = d[r][1];
			d[r][1] = d[r][2];
			d[r][2] = d[r][3];
			d[r][3] = d[r][4];
			d[r][4] = d[r][5];
			d[r][5] = d[r][6];
			d[r][6] = d[r][7];
			d[r][7] = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int [][] d = new int [4][8];
		for (int i=0; i<4; i++) {
			String s = kb.next();
			for (int j=0; j<8; j++) {
				d[i][j]= s.charAt(j)-'0';
			}
		}
		int k = kb.nextInt();
		while (k-->0) {
			int r = kb.nextInt()-1;
			int dir = kb.nextInt(); 
			int [] directions = new int [4]; //-2면 멈춤 
			directions[r] = dir;
			
			for (int i=r; i<3; i++) {
				if (d[i][2]!=d[i+1][6] && directions[i]!=-2) {
					directions[i+1]=directions[i]*-1;
				}else {
					directions[i+1]=-2;
				}
			}
			for (int i=r; i>0; i--) {
				if (d[i][6]!=d[i-1][2] && directions[i]!=-2) {
					directions[i-1]=directions[i]*-1;
				}else {
					directions[i-1]=-2;
				}
			}
			for (int i=0; i<4; i++) {
				turn(d,i,directions[i]);
			}
		}
		int sum=0;
		for (int i=0; i<4; i++) {
			if(d[i][0]==1) {
				sum+=(int)Math.pow(2, i);
			}
		}
		System.out.println(sum);
	}
}
