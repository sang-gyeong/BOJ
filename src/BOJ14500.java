import java.util.*;
public class BOJ14500 {//테트로미노 
    //사소한 실수들이 많았다(indexoutofArray 오류, 입력과정에서 알파벳 틀리기 등등)
    //실수만 줄이면 쉽게 풀 수 있는 문제
    public static void main(String[] args) {
  
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int [][] num = new int [n][m];
		for(int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				num[i][j]=kb.nextInt();
			}
		}
		//- 
		int sum = 0;
		for(int i=0;i<n;i++) {
			for (int j=0;j<m-3;j++) {
				int tmp = num[i][j]+num[i][j+1]+num[i][j+2]+num[i][j+3];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅣ 
		for(int i=0;i<n-3;i++) {
			for (int j=0;j<m;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i+2][j]+num[i+3][j];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅁ 
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i][j+1]+num[i+1][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅜ 
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i][j+2]+num[i+1][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅗ 
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i+1][j]+num[i+1][j+1]+num[i+1][j+2]+num[i][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅓ
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j+1]+num[i+1][j]+num[i+1][j+1]+num[i+2][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//ㅏ 
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i+1][j+1]+num[i+2][j];
				if (tmp > sum) sum=tmp;
			}
		}
		//L 
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i+2][j]+num[i+2][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//_ㅣ
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j+1]+num[i+1][j+1]+num[i+2][j+1]+num[i+2][j];
				if (tmp > sum) sum=tmp;
			}
		}
		//7
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i+1][j+1]+num[i+2][j+1];
				if (tmp > sum) sum=tmp;
			}
		}
		//|^
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i+1][j]+num[i+2][j];
				if (tmp > sum) sum=tmp;
			}
		}
		//^ㄱ 
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i][j+2]+num[i+1][j+2];
				if (tmp > sum) sum=tmp;
			}
		}
		//|^^
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i][j+2]+num[i+1][j];
				if (tmp > sum) sum=tmp;
			}
		}
		// ㄴ_
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i+1][j+1]+num[i+1][j+2];
				if (tmp > sum) sum=tmp;
			}
		}
		// __|
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i+1][j]+num[i+1][j+1]+num[i+1][j+2]+num[i][j+2];
				if (tmp > sum) sum=tmp;
			}
		}//지그재그1
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j]+num[i+1][j]+num[i+1][j+1]+num[i+2][j+1];
				if (tmp > sum) sum=tmp;
			}
		}//지그재그2
		for(int i=0;i<n-2;i++) {
			for (int j=0;j<m-1;j++) {
				int tmp=num[i][j+1]+num[i+1][j+1]+num[i+1][j]+num[i+2][j];
				if (tmp > sum) sum=tmp;
			}
		}//지그재그3
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i][j]+num[i][j+1]+num[i+1][j+1]+num[i+1][j+2];
				if (tmp > sum) sum=tmp;
			}
		}//지그재그4
		for(int i=0;i<n-1;i++) {
			for (int j=0;j<m-2;j++) {
				int tmp=num[i+1][j]+num[i+1][j+1]+num[i][j+1]+num[i][j+2];
				if (tmp > sum) sum=tmp;
			}
		}	
		System.out.println(sum);
		kb.close();
	}
}
