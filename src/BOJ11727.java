import java.util.Scanner;

public class BOJ11727 {
	
    static int [] d;
    
	static int go(int n) {
		if(n==1) return 1;
        if(n==2) return 3;
		if(d[n]>0) return d[n];
		d[n]=go(n-1)+(go(n-2)*2);
		return d[n]%=10007;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		d = new int [1001];
		System.out.println(go(n));
		
		kb.close();
	}
}


