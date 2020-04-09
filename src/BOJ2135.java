import java.util.*;

public class BOJ2135 {

	
	static int go(String str) {
		int answer = 0;
		char now = str.charAt(0);
		int tmp = 1;
		for (int i=1; i<str.length(); i++) {
			if(now!=str.charAt(i)) {
				answer++;
			}else {
				
			}
		}
		
		return answer;
	}
	
	static void goes() {
		
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		

	}

}
