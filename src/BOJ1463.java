import java.util.Scanner;
public class BOJ1463 {

	static int [] data;

	static int find(int n) {
		if (n==1) return 0;
		if (data[n]>0) return data[n];
		data[n] = find(n-1) +1 ;
		if (n%2==0) {
			int temp = find(n/2)+ 1;
			if (data[n]>temp) 
				data[n]=temp;
		}
		if (n%3==0) {
			int temp = find(n/3)+ 1;
			if (data[n]>temp) 
				data[n]=temp;
		}
		return data[n];
	}

	public static void main(String[] args) {
		data = new int[10^6];
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		System.out.println(find(n));
		kb.close();
	}
}