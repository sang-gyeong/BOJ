import java.util.Scanner;
public class BOJ2438 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.close();

		for (int i = 0; i<n; i++) {
			for (int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}