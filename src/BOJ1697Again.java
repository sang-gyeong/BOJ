import java.util.*;
public class BOJ1697Again {

	static ArrayList<Integer> list = new ArrayList<>();
	static boolean [] check = new boolean [100001];

	static void bfs(int now, int k, int sec) {
		if (now < 0 || now > 100000) {
			return;
		}
		if (now==k) {
			list.add(sec);
			return;
		}
		if (now-1 >=0) {
			if (check[now-1] == false) {
				check[now-1] = true;
				bfs(now-1, k, sec+1);
			}
		}
		if (now+1 <=100000) {
			if (check[now+1] == false) {
				check[now+1] = true;
				bfs(now-1, k, sec+1);
			}
		}
		if(now*2 <=100000) {
			if (check[now*2] == false) {
				check[now+2] = true;
				bfs(now-1, k, sec+1);
			}
		}
	}

	public static void main(String[] args) { //숨바꼭질 
		list = new ArrayList<>();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		Collections.sort(list);
		
		bfs(n, k, 0);

		int min = Integer.MAX_VALUE;
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)<min) {
				min =list.get(i);
			}
		}
		System.out.println(min);
	}

}
