import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class BOJ1874_2 {

	//
	//	static boolean yesorno(Stack<Integer> s, int d) {
	//		for (int i=0; i<s.size(); i++) {
	//			if (s.get(i)<d) {
	//				return false;
	//			}
	//		}
	//		return true;
	//	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int tmp = 0;
		int n = kb.nextInt();
		Stack <Integer> stack = new Stack<>();
		ArrayList <Object> output = new ArrayList<>();

		for (int i=0; i<n; i++) {
			int input = kb.nextInt();
			if (input<1||input>n) {
				break;}
			for (int i=0; i<n; )
			
			stack.add(i+1);
		}

		for (int i=0; i<n; i++) {
			if (stack[i] == n) {
				big = true;}

			else if(stack[i]>tmp && !big ) {
				for(int j=tmp; j<stack[i]; j++) {
					output.add("+");}
				output.add("-");
			}
			else if(stack[i]>tmp && big ) {
				System.out.println("NO");
				break;
			}

			else if (stack[i]<tmp) {
				for(int j=tmp; j>stack[i]; j--) {
					output.add("-");
				}
			}
			else if (stack[i]==tmp) {
				break;
			}
		}

		System.out.println(output);
		kb.close();
	}

}

