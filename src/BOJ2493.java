import java.util.*;      
public class BOJ2493 {//탑 
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Stack <Integer> stack = new Stack<>();
		HashMap <Integer, Integer> hashmap = new HashMap<>();

		int n = kb.nextInt();
		int [] a = new int [n];
		int [] d = new int [n];
		for (int i=0; i<n; i++) {
			a[i] = kb.nextInt();
			hashmap.put(a[i], i+1);
		}

		for (int i=0; i<n; i++) {
			int k = a[i];

			if(stack.isEmpty()) {
				d[i] = 0;
				stack.push(k);
			}else {
				if(stack.peek() > k) {
					d[i] = hashmap.get(stack.peek());
					stack.push(k);
				}else if (stack.peek() < k) {
					while (stack.peek() < k) {
						stack.pop();
						if (stack.isEmpty()) break;
						
					}
					if (stack.isEmpty()) {
						d[i] = 0;
						stack.push(k);
					}else if (stack.peek() > k) {
						d[i] = hashmap.get(stack.peek());
						stack.push(k);
					}	
				}
			}
		}
		for (int i=0; i<n; i++) {
			System.out.print(d[i] +" ");
		}

	}

}
