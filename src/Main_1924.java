import java.util.Scanner;

public class Main_1924 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		int x = kb.nextInt();
		int y = kb.nextInt();
		kb.close();

		int [] lastDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String [] day = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};

		String RealDay;
		int culDate = 0;
		int sum = 0;

		//if (x!=1){
		for(int i=0;i<x-1;i++) {
			sum += lastDate[i];
		}
		//}
		//else
		//	sum = 0;
		culDate = sum + y;
		RealDay = day[culDate % 7];

		System.out.println(RealDay);
	}
}