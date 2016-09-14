import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ServiceNames {
	public static String arrayListToString(ArrayList<String> list) {
		Iterator<String> iter = list.iterator();
		String str = "";
		while (iter.hasNext()) {
			str += iter.next();
			if (iter.hasNext())
				str += ", ";
		}
		return str;
	}
	
	public String[] makeList(String[] services) {
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

		for (int i=0; i<services.length; i++) {
			Scanner scan = new Scanner(services[i]);
			ArrayList<String> assoc = new ArrayList<String>();
			while (scan.hasNext()) {
				assoc.add(scan.next());
			}
			scan.close();
			
			for (int j=1; j<services.length; j++) {
				if (!map.containsKey(assoc.get(j))) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(assoc.get(0));
					map.put(assoc.get(j), list);
				}
				else {
					ArrayList<String> list = map.get(assoc.get(j));
					list.add(assoc.get(0));
					map.put(assoc.get(j), list);
				}
			}
		}
		
		TreeSet<String> keySet = (TreeSet<String>) map.keySet();
		ArrayList<ArrayList<String>> valuesList = (ArrayList<ArrayList<String>>) map.values();
		Iterator<String> iterKeys = keySet.iterator();
		Iterator<ArrayList<String>> iterValues = valuesList.iterator();
		String[] retStrs = new String[keySet.size()];
		int i=0;
		while (iterKeys.hasNext()) {
			retStrs[i++] = iterKeys.next() + " ==> " + arrayListToString(iterValues.next());
		}
		
		return retStrs;
	}
}
