import java.util.*;
public class BOJ10972 {

	static boolean next_permutation(int [] a) {
		int i = a.length-1;
		while (i>0 && a[i-1]>=a[i]) {
			i--;
		}
		if (i<=0) {
			return false;
		}
		int j = a.length - 1;
		while (a[j]<=a[i-1]) {
			j--;
		}
		int tmp = a[j];
		a[j] = a[i-1];
		a[i-1] = tmp;

		j = a.length -1; //i부터 오름차순으로 바꿔주기 
		while (i<j) {
			tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] a = new int [n];
		for (int i=0; i<n; i++) {
			a[i]=i+1;
		}

		do {
			for (int i=0; i<n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} while(next_permutation(a)); 

		kb.close();
	}
}


