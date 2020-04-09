import java.util.*;

public class BOJ1912 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] d = new int [n]; //주어진 배열 
		int [] a = new int [n];


		for (int i=0; i<n; i++) {
			d[i] = kb.nextInt();
		}
		a[0] = d[0];
		for (int i=1;i<n;i++) {
			a[i] = Math.max(d[i], a[i-1]+d[i]);
		}
		
		int max = a[0];
		for (int i=0;i<n;i++) {
			if(a[i]>max)
				max=a[i];
		}

		System.out.println(max);
		kb.close();
	}

}


