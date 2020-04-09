import java.util.*;

public class BOJ9613 {

	public static int gcd(int a, int b) {
		if (b==0) {
			return a;
		}
		else {
			return gcd(b,a%b);
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] answer = new int [n];

		for (int i=0;i<n;i++) {
			long sum = 0;	//long으로 해야함에 주의!
			int m = kb.nextInt();
			int [] arr = new int [m];
			for (int j=0;j<m;j++) {
				arr[j] = kb.nextInt();
			}
			
			for (int j=0;j<m;j++) { //m-1로 해도 무방 
				for (int k=j+1;k<m;k++) {
					sum += gcd(arr[j],arr[k]);
				}
			}
			System.out.println(sum);
		}
		
		kb.close();
	}

}
