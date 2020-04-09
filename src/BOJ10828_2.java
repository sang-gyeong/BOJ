import java.util.Scanner;
public class BOJ10828_2 {

	public static int size = 0;
	public static int [] stack = new int [10000];

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		for (int i=0; i<N; i++) {
			String input = kb.next();
			if (input.equals("push")) {
				int X = kb.nextInt();
				stack[size++] = X;
			}
			else if (input.equals("top")) {
				if (size ==0) 
					System.out.println(-1);
				else {
					System.out.println(stack[size-1]);
				}
			}
			else if (input.equals("size")) {
				System.out.println(size);
			}
			else if (input.equals("empty")) {
				if (size == 0) 
					System.out.println(1);
				else {
					System.out.println(0);
				}
			}
			else if (input.equals("pop")) {
				if (size ==0)
					System.out.println(-1);
				else {
					System.out.println(stack[size-1]);
					size--;
				}
			}
		}
		kb.close();
	}
}
