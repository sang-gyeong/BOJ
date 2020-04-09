import java.util.*;


public class BOJ16637 {

	static String plus(String a) {
		String b = "";
		int i =0;
		while(i<a.length()) {
			if(a.charAt(i)=='-' && a.charAt(i+1)=='-') {
				b+="+";
				i+=2;
			}else if(a.charAt(i)=='+' && a.charAt(i+1)=='-') {
				b+="-";
				i+=2;
			}
			else if(a.charAt(i)=='*' && a.charAt(i+1)=='-') {
				b+="#";
				i+=2;
			}
			else {
				b+=String.valueOf(a.charAt(i));
				i+=1;
			}
		}
		return b;
	}


	//
	//	static int cal2(String a) {
	//		char [] c = new char[a.length()];
	//		int tmp = 0;
	//		int i = 0;
	//		while(i<a.length() && tmp<a.length()) {
	//			if (a.charAt(i)<='9' && a.charAt(i)>='0') {
	//				int now = 0;
	//				while(true) {
	//					now*=10; 
	//					now+= a.charAt(i)-'0';
	//					i++;
	//					if(i==a.length()|| !(a.charAt(i)<='9' && a.charAt(i)>='0')) {
	//						break;
	//					}
	//				}
	//				c[tmp] = (char)now;
	//				tmp++;
	//				System.out.println(now);
	//			}else {
	//				c[tmp]=a.charAt(i);
	//				i++;
	//				tmp++;
	//			}
	//		}
	//	
	//		Queue <Character> q = new LinkedList<>();
	//		for (i=0; i<tmp; i++) {
	//			q.add(c[i]);
	//			System.out.println(c[i]);
	//		}
	//
	//		int answer = q.poll() - '0';
	//		while(!q.isEmpty()) {
	//			if (q.peek()=='*') {
	//				q.poll();
	//				if(q.peek()=='-') {
	//					q.poll();
	//					answer*=-1*q.poll()-'0';
	//				}else {
	//					answer*=q.poll()-'0';
	//				}
	//			}
	//			else if (q.peek()=='+') {
	//				q.poll();
	//				if(q.peek()=='-') {
	//					q.poll();
	//					answer-=q.poll()-'0';
	//				}else {
	//					answer+=q.poll()-'0';
	//				}
	//			}
	//			else if (q.peek()=='-') {
	//				q.poll();
	//				if(q.peek()=='-') {
	//					q.poll();
	//					answer+=q.poll()-'0';
	//				}else {
	//					answer-=q.poll()-'0';
	//				}
	//			}
	//		}
	//		return answer;
	//	}
	//
	//


	static int cal(String str) {
		int num = 0;
		int a = str.charAt(0)-'0';
		int b = str.charAt(2)-'0';
		if(str.charAt(1)=='*') {
			num=a*b;
		}else if(str.charAt(1)=='+') {
			num=a+b;
		}else if(str.charAt(1)=='-') {
			num=a-b;
		}


		return num;


	}



	static String s;
	static ArrayList<String> list = new ArrayList<>();

	static void go(int index, String now) {
		if(index>s.length()) return;
		if(index==s.length()) {
			list.add(plus(now));
//			System.out.println(plus(now));
			return;
		}
		if(!(s.charAt(index)<='9' && s.charAt(index)>='0')) {
			go(index+1, now+String.valueOf(s.charAt(index)));
		}else {
			go(index+1, now+String.valueOf(s.charAt(index)));
			if(index<s.length()-2) {
				go(index+3, now+ String.valueOf(cal(s.substring(index, index+3))));
			}
		}
	}


	static ArrayList<Integer>list2 = new ArrayList<>();
	static	ArrayList<Character>list3 = new ArrayList<>();
	static	ArrayList<Integer> ans = new ArrayList<>();
	static void replace(String s) {
		list2.clear();
		list3.clear();
		String str = "";
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='#' || s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*') {
				list3.add(s.charAt(i));
				str+=".";
			}else {
				str+=s.charAt(i);
			}
			
		}
	

		String [] nums = str.split(".");
		for(int i=0; i<nums.length; i++) {
			list2.add(Integer.parseInt(nums[i]));
		}
		int answer = s.charAt(0)-'0';
		for (int i=0; i<list3.size(); i++) {
			if(list3.get(i)=='#') {
				answer*=-1*list2.get(i+1);
			}else if(list3.get(i)=='*') {
				answer*=list2.get(i+1);
			}else if(list3.get(i)=='+') {
				answer+=list2.get(i+1);
			}else if(list3.get(i)=='-') {
				answer-=list2.get(i+1);
			}
		}
		ans.add(answer);
	}

	public static void main(String[] args) throws Exception{
		ans = new ArrayList<>();
		list = new ArrayList<>();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		s = kb.next();
		go(0, "");

		for (int i=0; i<list.size(); i++) {
			replace(list.get(i));
		}
		int max = ans.get(0);
		for (int i=0; i<ans.size(); i++) {
			if (ans.get(i) > max) {
				max = ans.get(i);
			}
		}
		System.out.println(max);




	}

}


