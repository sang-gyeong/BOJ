package Math;

import java.util.*;
public class Test2 {
	public int solution(String answer_sheet, String[] sheets) {
	
		ArrayList<Integer> list = new ArrayList<>();
		

		for (int i=0; i<sheets.length; i++) {
			for (int j=i+1; j<sheets.length; j++) {
				int count = 0; //총 의심문항 수 
				int len = 0; //의심문항 수 길이 
				int maxlen = 0; //가장 긴 연속된 의심문항 수 
				
				
				for (int k=0; k<answer_sheet.length(); k++) {
					if (answer_sheet.charAt(k)!=sheets[i].charAt(k) && sheets[i].charAt(k)==sheets[j].charAt(k)) {
						count++;
						len++;
						maxlen = Math.max(len, maxlen);
					}else {
						len=0;
					}
				}
				list.add(count + (maxlen*maxlen));
			}
		}
		int answer = 0;
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)>answer) {
				answer = list.get(i);
			}
		}

		return answer;
	}
}
