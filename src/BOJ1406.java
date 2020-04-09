import java.util.Scanner;
public class BOJ1406 {
	public static void main(String[] args) { //틀린결과

		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		char [] cases = new char [100000];
		int length = str.length();
		int tmp = length;
		int n = kb.nextInt();
		for (int i=0; i<n; i++) {
			for (int k=0; k<length; k++) {
			cases[i] = str.charAt(i);
			}
			String s = kb.next();
			if (s.equals("P")) {
				char w = kb.next().charAt(0);
				for (int j=length; j>=tmp; j--){
					cases[j+1] = cases[j];
				}
				cases[tmp] = w;
				tmp++;
				length++;
			}
			else if (s.equals("L")) {
				if (tmp>0) 
					tmp--;
				else
					return;
			}
			else if (s.equals("D")) {
				if (tmp<length) 
					tmp++;
			}
			else if (s.equals("B")) {
				if (tmp>0) {
					for (int j = tmp; j<=length; j++) {
						cases[j-1]= cases[j];
					}
					tmp--;
					length--;
				}
				else
					return;
			}
		}kb.close();
		for (int i=0; i<length; i++)
			System.out.print(cases[i]);
		
	}
}

