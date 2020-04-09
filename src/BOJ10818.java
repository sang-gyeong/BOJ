import java.util.Scanner;
public class BOJ10818 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];

		int min = 1000000;
		int max = -1000000;
		for (int i = 0; i<=n-1; i++) {
			data[i] = kb.nextInt(); 
			if (data[i] >= max) 
				max = data[i];
			if (data[i]<= min) 
				min = data[i];
		}
		kb.close();
		System.out.print(min);
		System.out.print(" ");
		System.out.print(max);
	}
}