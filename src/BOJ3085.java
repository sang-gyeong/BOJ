import java.util.*;
public class BOJ3085 {
	static int check(char[][]a) {
		int n = a.length;
		int ans = 1;
		for (int i=0;i<n;i++) {
			int cnt=1;
			for (int j=1; j<n;j++) {
				if (a[i][j]==a[i][j-1]) {
					cnt +=1;
				}
				else {
					cnt = 1;
				}
				if (ans<cnt) ans = cnt;
			}
			cnt=1;
			for (int j=1; j<n; j++) {
				if(a[j][i]==a[j-1][i]) {
					cnt +=1;
				}
				else {
					cnt = 1;
				}
				if (ans < cnt) ans = cnt;
			}
		}
		return ans;
	}

	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		char [][] a = new char [n][n];

		for(int i=0;i<n;i++) {
			a[i] = kb.next().toCharArray(); // 스트링을 새로운 문자배열로 변환 
		}
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (j+1<n) {
					char t = a[i][j]; a[i][j]=a[i][j+1];a[i][j+1]=t; //swap 
					int temp = check(a);
					if (ans<temp) ans = temp;
					t = a[i][j]; a[i][j]=a[i][j+1];a[i][j+1]=t; //다시 되돌리기 
				}
				if (i+1<n) {
					char t = a[i][j]; a[i][j]=a[i+1][j];a[i+1][j]=t; //swap 
					int temp = check(a);
					if (ans<temp) ans = temp;
					t = a[i][j]; a[i][j]=a[i+1][j];a[i+1][j]=t; //다시 되돌리기 
				}
			}
		}
		System.out.println(ans);
		kb.close();
	}
}

