import java.util.*;
public class BOJ14499 {//주사위굴리기 
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int x = kb.nextInt();
		int y = kb.nextInt();
		int k = kb.nextInt();
		int [] dice = new int [7];
		int [] order = new int [k];
		int [][] d = new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				d[i][j] = kb.nextInt();
			}
		}
		for (int i=0; i<k; i++) {
			order[i] = kb.nextInt();
		}
		
		for (int i=0; i<7; i++) {
			dice[i]=0;
		}
		int dx=x;
		int dy=y;
		for (int i=0; i<k; i++) {
			
			if (order[i]==1) {
				dy=y+1;
				if (dx<0||dx>=n||dy<0||dy>=m) {
					dx=x;
					dy=y;
					continue;
				}
				int tmp=dice[1];
				dice[1]=dice[4];
				dice[4]=dice[6];
				dice[6]=dice[3];
				dice[3]=tmp;	
			}
			else if (order[i]==2) {
				dy=y-1;
				if (dx<0||dx>=n||dy<0||dy>=m) {
					dx=x;
					dy=y;
					continue;
				}
				int tmp=dice[1];
				dice[1]=dice[3];
				dice[3]=dice[6];
				dice[6]=dice[4];
				dice[4]=tmp;		
			}
			else if (order[i]==3) {
				dx=x-1;
				if (dx<0||dx>=n||dy<0||dy>=m) {
					dx=x;
					dy=y;
					continue;
				}
				int tmp=dice[1];
				dice[1]=dice[5];
				dice[5]=dice[6];
				dice[6]=dice[2];
				dice[2]=tmp;		
			}
			else if (order[i]==4) {
				dx=x+1;
				if (dx<0||dx>=n||dy<0||dy>=m) {
					dx=x;
					dy=y;
					continue;
				}
				int tmp=dice[1];
				dice[1]=dice[2];
				dice[2]=dice[6];
				dice[6]=dice[5];
				dice[5]=tmp;
			}		
			x=dx;
			y=dy;	
			if (d[x][y]==0) {
				d[x][y] = dice[6];
			}
			else if (d[x][y]>0){
				dice[6] = d[x][y];
				d[x][y]= 0;	
			}		
			System.out.println(dice[1]);
		}
	}
}
