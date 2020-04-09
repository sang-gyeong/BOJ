package Math;
import java.util.*;
public class Test4 {
	public String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};
		
		
		boolean [] check = new boolean [transactions.length];
		HashMap<String, Integer> hashmap = new HashMap<>();
		
		for (int i=0; i<snapshots.length; i++) {
			hashmap.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		
		for (int i=0; i<transactions.length; i++) {
			if (check[Integer.parseInt(transactions[i][0])] == true ) {
				continue;
			}else {
				check[Integer.parseInt(transactions[i][0])] = true ;
				
				
				
				
				if (transactions[i][1].equals("SAVE")) {
					
					
					
				}else {
					
					
				}
				
				
				
			}
			
			
		}
		
		
		
		
		return answer;
	}
}
