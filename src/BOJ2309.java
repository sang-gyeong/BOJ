import java.util.*;

public class BOJ2309 {

	public static void main(String[] args) {
		int sum=0;
		Scanner kb = new Scanner(System.in);
		List<Integer> dwarves = new ArrayList<>();
		int [] fake = new int [2];
		List<Integer> answer = new ArrayList<>();
		
		
		for(int i=0;i<9;i++) {
			dwarves.add(kb.nextInt());
			sum+=dwarves.get(i);
		}
		
		
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if (dwarves.get(i)+dwarves.get(j)==sum-100) {
					fake[0]=dwarves.get(i);
					fake[1]=dwarves.get(j);
				}	
			}
		}
		
		for (int i=0; i<dwarves.size();i++) {
			if(dwarves.get(i)!=fake[0]&&dwarves.get(i)!=fake[1]) {
				answer.add(dwarves.get(i));
			}
		}
			
		answer.sort(null);
		
		for(int i=0; i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		kb.close();
	}
}
