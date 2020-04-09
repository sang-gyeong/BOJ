
import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {

	public static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		int n = kb.nextInt();
		kb.nextLine();
		String isVPN="YES";
		for (int i=0; i<n; i++) {
			Stack <Character> stack = new Stack<>();
			String str = kb.nextLine();
			for (int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(c == '(') {
					stack.add(c);
				}
				else if (c==')' && !stack.empty()) {
					stack.pop();
				}
				else if (c==')' && stack.empty()) {
					isVPN = "NO"; //스택이 빈 상태에서 )가 나타나면 무조건NO
					stack.add(c);
				}
			}
			if (stack.empty() && !isVPN.equals("NO")) { //세번째케이스 검
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			isVPN = "YES"; //(주의) isVPN초기화 
		}
		kb.close();

	}	
}

