import java.util.*;
import java.io.*;

public class BOJ1406_3 { //BufferdReader버젼 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack <Object> left = new Stack<>();
		Stack <Object> right = new Stack<>();

		for(int i=0; i<s.length();i++) {
			left.push(s.charAt(i));
		}	
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			String [] line = br.readLine().split(" ");
			char c = line[0].charAt(0);
			if (c == 'L' &&!left.empty()) {
				right.push(left.pop());	
			}
			else if (c == 'D' &&!right.empty()) {
				left.push(right.pop());	
			}
			else if (c == 'B' &&!left.empty()) {
				left.pop();
			}
			else if (c == 'P') {
				left.push(line[1].charAt(0));
			}
		}

		while(!left.empty()) {
			right.push(left.pop());
		}

		StringBuilder sb = new StringBuilder();
		while(!right.empty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}
}
