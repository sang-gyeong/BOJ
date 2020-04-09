import java.util.Scanner;
public class Main_11721 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		String str = kb.next(); 

		int a = 0;
		int b = 10;
		int l = str.length();

		while (l>10){
			System.out.println(str.substring(a, b));
			a += 10;
			b += 10;
			l -= 10;

			if (l<=10) {
				System.out.println(str.substring(a,a+l));
			}
		}   
		kb.close();
	}
}

