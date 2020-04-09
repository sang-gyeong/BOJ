import java.util.Scanner;
public class BOJ2522 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.close();

		for(int i=0; i<n; i++) {

			for (int j=n-1; j>i; j--) {
				System.out.print(" ");
			}
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for(int i=n-1; i>=1;i--) {
			for (int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
