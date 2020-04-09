
import java.util.Scanner;
import java.util.Stack;

public class BOJ9093 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.nextLine();
		
		for(int i=0; i<n; i++) {
			Stack <Object> stack = new Stack<>();
			String input = kb.nextLine();
			for(int j=0; j<input.length(); j++) {
				char c = input.charAt(j);
				if (c == ' ') {
					while(!stack.empty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				}else {
					stack.add(input.charAt(j));
				}
			}
			while(!stack.empty()) {
				System.out.print(stack.pop());
			}
			System.out.println();
		}
		kb.close();	
	}
}


