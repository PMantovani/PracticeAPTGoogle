import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TheBestName {

	public class CompareName implements Comparator<String> {
		
		@Override
		public int compare(String arg0, String arg1) {
			if (arg0.equals("JOHN"))
				return -1;
			if (arg1.equals("JOHN"))
				return 1;
			
			int sum0 = 0;
			for (int i=0; i<arg0.length(); i++) {
				sum0 += (arg0.charAt(i)-64);
			}
			int sum1 = 0;
			for (int i=0; i<arg1.length(); i++) {
				sum1 += (arg1.charAt(i)-64);
			}
			
			if (sum1 != sum0)
				return sum1-sum0;
			return arg0.compareTo(arg1);
		}
	}
	
	public String[] sort(String[] names) {
		ArrayList<String> nameList = new ArrayList<String>();
		for (String name : names) {
			nameList.add(name);
		}
		Arrays.sort(names, new CompareName());
		Collections.sort(nameList, new CompareName());
		return names;
	}
}
