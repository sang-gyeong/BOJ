import java.util.*;
public class BOJ1759 {

	static boolean check(String password) {
		int ja = 0;
		int mo = 0;
		for (char x : password.toCharArray()) {
			if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') {
				mo +=1;
			}else {
				ja +=1;
			}				
		}
		return (ja>=2 && mo>=1);	
	}
	static void go(int n, String[]s, String password, int i) {
		if (password.length()==n) {
			if(check(password)) {
				System.out.println(password);
			}return;
		}
		if (i>=s.length) return;
		go(n, s, password+s[i], i+1);
		go(n, s, password, i+1);
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		String[] s = new String [m];
		for (int i=0; i<m; i++) {
			s[i] = kb.next();
		}	
		Arrays.sort(s);
		go(n, s, "", 0);
	}
}
