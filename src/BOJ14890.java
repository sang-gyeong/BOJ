import java.util.*;
public class BOJ14890 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int l = kb.nextInt();
		int [][]d = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				d[i][j]=kb.nextInt();
			}
		}
		
		for (int i=0; i<n; i++) {
			int yeon = 1;
			for (int j=0; j<n-1; j++) {
				if (d[i][j]==d[i][j+1]) {
					yeon++;
				}else if(d[i][j+1]-d[i][j]==1){
					yeon=1;
					if (yeon>=l) {
						for (int k=j; k>=j-l+1;k--) {
							d[i][k]=-1;
						}
					}else {
						break;
					}
				}else if (d[i][j+1]-d[i][j]==-1) {
					yeon=1;
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
			}
		}
		
		

	}

}
