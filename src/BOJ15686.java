import java.util.*;
public class BOJ15686 { //치킨 배달 
	static int n;
	static int m;
	static int answer =987654321;
	static int [][] a = new int [53][53];
	static List <Pair> house;
	static List <Pair> store;
	static List <Pair> remain;
	public static void copy(int[][]w, int [][]q) { //복사 및 map 초기화 
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				w[i][j]=q[i][j];
			}
		}
	}
	public static int count(int [][]q) {
		int count =0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (q[i][j]==2) {
					remain.add(new Pair(i,j));
					count++;
				}
			}
		}
		return count;
	}
	public static void distance(int [][]q) {
		int sum=0;
		for (int i=0; i<house.size();i++) {
			int min=987654321;
			for (int j=0; j<remain.size();j++) {
				int dis = Math.abs(house.get(i).x-remain.get(j).x) + 
						Math.abs(house.get(i).y-remain.get(j).y);			
				if (dis==1) {
					min = 1;
					break;
				}
				if (dis<min) {
					min = dis;
				}
			}
			sum+=min;
		}
		if (answer>sum) answer = sum;
		remain.clear();
	}
	public static void go(int index, int [][] q) {//가능한 map의 경우 만들기 
		if (index>store.size()) return;
		if (index==store.size()) {
			int c = count(q);
			if(c==m) distance(q);
			remain.clear();
			return;
		}
		int [][] w = new int [n][n];
		go(index+1, q);
		copy(w,q); //******
		w[store.get(index).x][store.get(index).y]=2;
		go(index+1, w);
	}
	public static void main(String[]args) {
		Scanner kb = new Scanner(System.in);
		house = new ArrayList<>();
		store = new ArrayList<>();
		remain = new ArrayList<>();
		n = kb.nextInt();
		m = kb.nextInt();
		a = new int [n][n];

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				a[i][j]=kb.nextInt();
				if (a[i][j]==1) {
					house.add(new Pair(i,j));
				}else if (a[i][j]==2) {
					store.add(new Pair(i,j));
					a[i][j]=0;
				}
			}
		}
		go(0,a);
		System.out.println(answer);
	}
}
