import java.util.*;
public class BOJ1107 {

	static boolean [] broken = new boolean [10];

	static int possible(int c) { // 숫자만 눌렀을때 버튼수 리턴. 
		if (c==0) {
			if(broken[0]) {//0이 고장난 버튼인 경우 
				return 0;
			}
			else {
				return 1;
			}
		}
		int len = 0;
		while (c>0) {
			if (broken[c%10]) { //c에 포함된 수가 고장난경우 
				return 0;
			}
			len+=1;
			c/=10;
		}
		return len; 
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();

		for(int i=0; i<m; i++) {
			int x = kb.nextInt();
			broken[x]=true;
		}
		int ans = Math.abs(100-n);

		for (int i=0; i<=1000000;i++) {
			int c = i;
			int len = possible(c);
			if (len>0) {//고장난 버튼이 포함되지 않은 경우 
				int press = Math.abs(n-c);

				if (ans > press+len) {
					ans = press+len;
				}
			}
		}
		System.out.println(ans);
		kb.close();
	}
}
