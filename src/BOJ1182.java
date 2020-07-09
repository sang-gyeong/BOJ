import java.util.*;

public class BOJ1182 {
	
	static int answer = 0;
	
	static void go(int[]a, int index, int sum, int s) {
		if (index==a.length) {
			System.out.println(sum);
			return;
		}
		if (sum==s) {
			answer++;
		}
		go(a, index+1, sum+a[index], s);
		go(a, index+1, sum, s);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int s = kb.nextInt();
		
		int [] a = new int [n];
		for (int i=0; i<n; i++) {
			a[i] = kb.nextInt();
		}
		go(a, 0, 0, s);
		
		System.out.println(answer);
		

	}

}
