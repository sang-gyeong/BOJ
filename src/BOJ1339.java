import java.util.*;

public class BOJ1339 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int answer = 0;
		String [] a = new String [n];
		for (int i=0; i<n; i++) {
			a[i] = kb.next();
		}
		
		HashMap <Character, Integer> map = new HashMap<>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<a[i].length(); j++) {
				char now = a[i].charAt(j);
				if (map.containsKey(now)) {
					int tmp = map.get(now);
					map.put(now, tmp+(int)(Math.pow(10, a[i].length()-1-j)));
				}else {
					map.put(now, (int)(Math.pow(10, a[i].length()-1-j)));
				}
			}
		}
		int [] ans = new int [map.size()];
		
		for (int i=0; i<map.size(); i++) {
			
		}
		
		
		System.out.println(map.keySet());
		

	}

}
