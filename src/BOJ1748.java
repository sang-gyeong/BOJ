import java.util.*;
public class BOJ1748 { //수 이어쓰기1

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		long sum = 0;
		
		for (int start = 1, len=1; start<=n; start*=10, len++) {
			int end = start*10-1;
			if(end>n) {
				end = n;
			}
			sum += (long)(end - start + 1)*len;
		}
		System.out.println(sum);
	}
}
