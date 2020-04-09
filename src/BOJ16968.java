import java.util.*;
public class BOJ16968 {//차량 번호판1 
	static int answer;
	public static void go(int index, char next, String str, String s) {
		if (s.length() ==str.length()) {
			answer++;
			return;
		}
		if(s.charAt(index)=='c') {
			for (char i='0'; i<='9'; i++) {
				if (next!=i) {
					go(index+1, i, str+i, s);
				}else {
					continue;
				}
			}
		}
		else if(s.charAt(index)=='d') {
			for (char i='a'; i<='z'; i++) {
				if (next!=i) {
					go(index+1, i, str+i, s);
				}else {
					continue;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		String s = kb.next();
		System.out.println();
		answer = 0;
		String str = "";
		go(0,' ',str, s);
		System.out.println(answer);
	}
}
