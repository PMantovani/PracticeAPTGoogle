import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class SortByFreqs {
	
	HashMap<String, Integer> countMap = new HashMap<String, Integer>();
	
	public class FreqComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			int count0 = countMap.get(arg0);
			int count1 = countMap.get(arg1);
			if (count0 == count1)
				return arg0.compareTo(arg1);
			return count1-count0;
		}
		
	}
	
	public String[] sort(String[] data) {
		for (int i=0; i<data.length; i++) {
			int count = 0;
			if (countMap.containsKey(data[i])) {
				count = countMap.get(data[i]);
			}
			countMap.put(data[i], count+1);
		}
		
		ArrayList<String> keyList = new ArrayList<String>(countMap.keySet());
		Collections.sort(keyList, new FreqComparator());
		String[] sortedData = new String[keyList.size()];
		sortedData = keyList.toArray(sortedData);
		return sortedData;
	}
}
