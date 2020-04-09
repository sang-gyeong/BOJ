package Math;
import java.util.*;
public class Test3 {

	static ArrayList<Integer> list = new ArrayList<>();

	static int maxLen(String now) {
		int len=0;
		int tmp=0;
		for (int i=0; i<now.length(); i++) {
			if (now.charAt(i)=='1') {
				tmp++;
				len = Math.max(tmp, len);
			}else if (now.charAt(i)=='0') {
				tmp=0;
			}
		}	
		return len;
	}
	
	static String copy(int i, String now) {
		String c = "";
		for (int j=0; j<now.length(); j++) {
			if (j==i) {
				c+='1';
			}else {
				c+=now.charAt(j);
			}
		}
		return c;
	}
	
	
	static void go(int fixed, String now, int n) {
		if (fixed > n) return;
		if (fixed==n) { 
			list.add(maxLen(now));
			return;
		}
		for (int i=0; i<now.length(); i++) {
			if (now.charAt(i)=='0') {
				go(fixed, now, n);
				String c = copy(i, now);
				go(fixed+1, c, n);
			}
		}
	}
	
	public int solution(String road, int n) {
		list = new ArrayList<>();
		int answer = 0;
		
		if (road.length()<=n ) {
			return road.length();
		}
		
		int zerocount=0;
		for (int i=0; i<road.length(); i++) {
			if (road.charAt(i)=='0') {
				zerocount++;
			}
		}
		if (zerocount <= n) { //0의 갯수가 고칠수있는 횟수보다 적은경우 
			return road.length();
		}
		if (zerocount == road.length()) {//다리 전부가 0인경우. 00000..
			return n;
		}
		
		go(0, road, n);
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) > answer) {
				answer = list.get(i);
			}
		}
		
		return answer;
	}


}
