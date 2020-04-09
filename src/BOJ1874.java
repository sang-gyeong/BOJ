import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.ArrayList;

public class BOJ1874 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int tmp = 0;
		int n = kb.nextInt();
		Stack <Integer>stack = new Stack <>();
		ArrayList <Object> output = new ArrayList<>();

		for (int i=0; i<n; i++) {
			int input = kb.nextInt();
			if (input<1||input>n) {
				break;
			}
			else if(input>tmp) {
							if(!stack.contains(input)){
							output.clear();
							output.add("NO");
						}
				for(int j=tmp; j<input; j++) {
					stack.push(j+1);
					output.add("+");
				}
				if (!stack.empty()) {
				stack.pop();
				output.add("-");
				tmp=input;
				}
			}

			else if(input<tmp) {
				while(stack.peek()!=-1&&stack.peek()>=input&&!stack.empty()) {
					stack.pop();
					output.add("-");
				}
				tmp = input;

			}

		}
		for (int i=0; i<output.size(); i++) {
			System.out.println(output.get(i));
		}
		kb.close();
	}
}