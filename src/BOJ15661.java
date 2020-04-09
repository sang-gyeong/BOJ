import java.util.*;
public class BOJ15661 {//링크와 스타트 
	static int n;
	static int [][] num = new int [22][22];
	static int ans = Integer.MAX_VALUE;
	static void go(int index, String s1, String s2) {
		if (index==n) {
			if (s1.length()==0 || s2.length()==0) return;
			int sum1=0;
			int sum2=0;
			for (int i=0; i<s1.length(); i++) {
				for (int j=0; j<s1.length(); j++) {
					if (i==j) continue;
					sum1+=num[s1.charAt(i)-'0'][s1.charAt(j)-'0'];
				}
			}
			for (int i=0; i<s2.length(); i++) {
				for (int j=0; j<s2.length(); j++) {
					if (i==j) continue;
					sum2+=num[s2.charAt(i)-'0'][s2.charAt(j)-'0'];
				}
			}
			ans = Math.min(ans,Math.abs(sum1-sum2));
			return;
		}	
		String t = String.valueOf(index);
		go(index+1, s1+t, s2);
		go(index+1, s1, s2+t);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		num = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				num[i][j] = kb.nextInt();
			}
		}
		go(0, "", "");
		System.out.println(ans);
	}
}

