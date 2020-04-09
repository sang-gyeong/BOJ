package Math;
import java.util.*;
public class Test5 {
	public String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};
		Map <String, Integer> hashmap = new HashMap<>();


		for (int i=0; i<dataSource.length; i++) {
			int tmp=0;
			for (int j=0; j<dataSource[i].length; j++) { //
				for (int k=0; k<tags.length; k++) {
					if (tags[k].equals(dataSource[i][j])) {
						tmp++;
					}
				}
			}
			if (tmp!=0) {
				hashmap.put(dataSource[i][0], tmp);
			}
		}



		List<Map.Entry<String, Integer>> list = new LinkedList<>(hashmap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int comparision = (o1.getValue() - o2.getValue()) * -1;
				return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
			}
		});


		Map<String, Integer> sortedMap = new LinkedHashMap<>(); 
		for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
			Map.Entry<String, Integer> entry = iter.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}


	
		List<String> l = new ArrayList<>();
			for (String key : sortedMap.keySet()) {
				l.add(key);
			}
		
		if (l.size() > 10) {
			answer = new String [10];
			for (int i=0; i<10; i++) {
				answer[i] = l.get(i);
			}
		}else {
			answer = new String [l.size()];
			for (int i=0; i<l.size(); i++) {
				answer[i] = l.get(i);
			}
		}


		return answer;
	}
}
