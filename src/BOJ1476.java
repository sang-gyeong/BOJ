import java.util.*;
public class BOJ1476 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int E = kb.nextInt();
		int S = kb.nextInt();
		int M = kb.nextInt();
		
		kb.close();
		
		int e=1,s=1,m=1;
		for (int i=1;;i++) {
			if (e==E&&s==S&&m==M) {
				System.out.println(i);
				break;
			}
			e +=1;
			s +=1;
			m +=1;
			if (e==16) {
				e=1;
			}
			if (s==29) {
				s=1;
			}
			if (m==20) {
				m=1;
			}
		}
	}
}
