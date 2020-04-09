import java.util.Scanner;
public class BOJ2445 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.close();

		int [] array = new int [2*n-1];
		for (int i=0; i<n;i++) {
			array[i] = i+1;
		}
		for (int i=n; i<2*n-1; i++) {
			array [i] = 2*n-1-i;
		}
		
		for (int i=0; i<2*n-1; i++) {
			for (int j = 0; j<array[i] ;j++) {
			System.out.print("*");
				
		}
			for (int j = 0; j<2*n-2*array[i]; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j<array[i] ;j++) {
				System.out.print("*");
					
			}
			System.out.println();

		}
	}
}
