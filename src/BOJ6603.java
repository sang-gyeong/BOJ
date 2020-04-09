import java.util.*;
public class BOJ6603 {

	static boolean next_permutation(int [] arr) {
		int i = arr.length -1;
		while (i>0 && arr[i-1]>=arr[i]) {
			i-=1;
		}
		if (i<=0) return false;

		int j = arr.length -1;
		while (arr[j]<=arr[i-1]) {
			j-=1;
		}
		int tmp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = arr[j];

		j = arr.length -1;
		while(j>i) {
			tmp = arr[j];
			arr[j] = arr[i];
			arr[i] = tmp;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		while (true) {
			int n = kb.nextInt();
			if (n==0) break;
			int [] a = new int [n];
			int [] check = new int [n];

			for (int i=0; i<n;i++) {
				a[i] = kb.nextInt();
			}		

			for (int i=0; i<n; i++) {
				if (i < n-6) check[i] = 0;
				else check[i] = 1;
			}

			do {
				ArrayList <Integer> list = new ArrayList<>();
				for(int i=0; i<n; i++) {
					if(check[i]==1) {
						list.add(a[i]);
					}
				}

				int [] tmp = new int [6];
				for (int i=0; i<6;i++) {
					tmp[i]=list.get(i);
				}

				do {
					for (int i=0; i<6; i++) {
						System.out.print(tmp[i] +" ");
					}
					System.out.println();

				}while(next_permutation(tmp));	
			}while(next_permutation(check));



		}
		kb.close();
	}

}
