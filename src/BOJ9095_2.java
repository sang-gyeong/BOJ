import java.util.*;

public class BOJ9095_2 { //브루트포스-재귀 

	static int go(int sum, int goal) {
		if (sum>goal) return 0;
		if (sum==goal) return 1;
		
		int now = 0;
		for (int i=0; i<=3; i++) {
			now+=go(sum+i, goal);
		}
		return now;
	}

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int ans = go(0,n);
		System.out.println(ans);
		
	}
}

