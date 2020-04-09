package Math;

import java.util.*;
public class Test1 {
	public int solution(String inputString) {
		int answer = 0;

		Stack <Character> stack1 = new Stack<>(); //()
		Stack <Character> stack2 = new Stack<>(); //{}
		Stack <Character> stack3 = new Stack<>(); //[]
		Stack <Character> stack4 = new Stack<>(); //<>
		
		for (int i=0; i<inputString.length(); i++) {
			if (inputString.charAt(i)=='(') {
				stack1.push('(');
			}else if (inputString.charAt(i)==')') {
				if (stack1.isEmpty()) {
					return -1;
				}else if(stack1.peek()==')'){
					return -1;
				}else if(stack1.peek()=='('){
					stack1.pop();
					answer++;
				}
			}
			else if (inputString.charAt(i)=='{') {
				stack2.push('{');
			}else if (inputString.charAt(i)=='}') {
				if (stack2.isEmpty()) {
					return -1;
				}else if(stack2.peek()=='}'){
					return -1;
				}else if(stack2.peek()=='{'){
					stack2.pop();
					answer++;
				}
			}
			else if (inputString.charAt(i)=='[') {
				stack3.push('[');
			}else if (inputString.charAt(i)==']') {
				if (stack3.isEmpty()) {
					return -1;
				}else if(stack3.peek()==']'){
					return -1;
				}else if(stack3.peek()=='['){
					stack3.pop();
					answer++;
				}
			}
			else if (inputString.charAt(i)=='<') {
				stack4.push('<');
			}else if (inputString.charAt(i)=='>') {
				if (stack4.isEmpty()) {
					return -1;
				}else if(stack4.peek()=='>'){
					return -1;
				}else if(stack4.peek()=='<'){
					stack4.pop();
					answer++;
				}
			}
		}
		
		if(!stack1.isEmpty() || !stack2.isEmpty() || !stack3.isEmpty() || !stack4.isEmpty() ) {
			return -1;
		}
		
			return answer;
	}
}
