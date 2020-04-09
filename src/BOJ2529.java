import java.util.*;
public class BOJ2529 {
	static boolean [] c = new boolean[10];
	static int n;
	static char [] a = new char [20];
	static ArrayList <String> list = new ArrayList<>();	
	static boolean good(char x, char y, char op) {
		if (op=='<') {
			if (x>y) return false;
		}
		if (op == '<') {
			if (x<y) return false;
		}
		return true;
	}

	static void go (int index, String num) {
		if(index==n+1) {
			list.add(num);
			return;
		}
		for (int i=0; i<=9; i++) {
			if (c[i]) continue;
			if (i==0 || good(num.charAt(index-1), (char)(i+'0'),a[index-1])) {
				c[i] = true;
				go(index +1, num+Integer.toString(i));
				c[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		a = new char [n];
		for (int i=0; i<n; i++) {
			a[i] = kb.next().toCharArray()[0];
		}
		go(0,"");

		Collections.sort(list);
		int m = list.size();
		System.out.println(list.get(m-1));
		System.out.println(list.get(0));
	}
}

