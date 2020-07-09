import java.util.*;
public class BOJ6603 {

	static ArrayList <Integer> list = new ArrayList<>();
	
	static void go(int [] a, int index, int cnt) {
		if (cnt==6) {
			for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
		}
		int n = a.length;
		if (n==index) return;
		list.add(a[index]);
		go(a, index+1,cnt+1);
		list.remove(list.size()-1);
		go(a, index+1, cnt);
	}
	
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		while (true) {
			int n = kb.nextInt();
			if (n==0) break;
			int [] a = new int [n];

			for (int i=0; i<n; i++) {
				a[i] = kb.nextInt();
			}
			
			go(a, 0, 0);
			System.out.println();
		}
		kb.close();
	}

}
