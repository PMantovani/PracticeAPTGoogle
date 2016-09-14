import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class MemberCheck {
	
	public String[] whosDishonest(String[] club1, 
            String[] club2, 
            String[] club3) {
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		HashSet<String> set3 = new HashSet<String>();
		
		for (int i=0; i<club1.length; i++) {
			set1.add(club1[i]);
		}
		for (int i=0; i<club2.length; i++) {
			set2.add(club2[i]);
		}
		for (int i=0; i<club3.length; i++) {
			set3.add(club3[i]);
		}
		
		HashSet<String> copy1 = (HashSet<String>) set1.clone();
		HashSet<String> copy2 = (HashSet<String>) set1.clone();
		HashSet<String> copy3 = (HashSet<String>) set2.clone();
		
		copy1.retainAll(set2);
		copy2.retainAll(set3);
		copy3.retainAll(set3);
		
		copy1.addAll(copy2);
		copy1.addAll(copy3);
		
		String[] dishonests = new String[copy1.size()];
		Iterator<String> it = copy1.iterator();
		int i=0;
		while (it.hasNext()) {
			dishonests[i] = it.next();
			i++;
		}
		Arrays.sort(dishonests);
		
		
		return dishonests;
	}
}
