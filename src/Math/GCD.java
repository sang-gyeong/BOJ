package Math;
import java.util.*;

public class GCD {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		while (b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		System.out.println(a);
		
	}

}
