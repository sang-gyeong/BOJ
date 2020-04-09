import java.util.*;
public class TestTest { //숨바꼭질. 왜 틀렸는지?!!!!!
	static boolean [] check = new boolean [100001];
	static int [] d = new int [100001];
	static int n;
	static int k;
	static void bfs() {
		Queue <Integer> q = new LinkedList<>();
		check[n]=true;
		d[n] = 0;
		q.add(n);
		while(!q.isEmpty()) {
			int x = q.poll();
			int [] cases = {x-1, x+1, x*2};
			for (int y : cases) {
				if(y>=0 && y<=k) {
					if (check[y]==false) {
                        if(y==k){
                            System.out.println(d[x]+1);
                            System.exit(0);
                        }
						check[y]=true;
						d[y] = d[x]+1;
						q.add(y);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		k = kb.nextInt();
		check = new boolean [100001]; 
		d = new int [100001];

		bfs();
		System.out.println(d[k]);
	}
}
