import java.util.*;

public class BOJ10844 {

	public static void main(String[] args) {
		int [] d = new int [101];
		int b = 1000000000;
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		d[1] = 9;
		for (int i=2; i<=n; i++) {
			d[i] = (int)((2 * d[i-1] - (int)Math.pow(2,i-2))%b);
		}	
		
		System.out.println(d[n]);
		kb.close();
	}

}


//알고보니 2차원 배열을 사용해야 하는 거였음.
//앞서 풀었던 1,2,3 더하기 5 문제와 유사