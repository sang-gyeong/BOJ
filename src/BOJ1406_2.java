import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class BOJ1406_2 {
	public static void main(String[] args) { //Scanner버젼 

		Stack <Object> left_stack = new Stack<>();
		Stack <Object> right_stack = new Stack<>();
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		for(int i=0; i<s.length();i++) {
			left_stack.push(s.charAt(i));
		}	
		int n = kb.nextInt();
		for (int i=0; i<n; i++) {
			String c = kb.next();
			if (c.equals("L")&&!left_stack.empty()) {
				right_stack.push(left_stack.pop());	
		}
			else if (c.equals("D")&&!right_stack.empty()) {
				left_stack.push(right_stack.pop());	
		}
			else if (c.equals("B")&&!left_stack.empty()) {
				left_stack.pop();
		}
			else if (c.equals("P")) {
				left_stack.push(kb.next());
			}
		}
		kb.close();
		while(!left_stack.empty()) {
			right_stack.push(left_stack.pop());
		}
		ArrayList<Object>result = new ArrayList<>();
		while(!right_stack.empty()) {
		result.add(right_stack.pop());
		}
		
		for(int i=0; i<result.size();i++) {
		System.out.print(result.get(i));
		}
	}
}