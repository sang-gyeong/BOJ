import java.util.Scanner;
public class BOJ10992 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.close();

		for(int i=0; i<n-1; i++) {
			for (int j=n-1; j>i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j=0; j<2*i-1; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for (int i=0; i<2*n-1; i++) {
			System.out.print("*");
		}
	}
}