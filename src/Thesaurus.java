import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Thesaurus {
	
	public static TreeSet<String> stringToSet(String s) {
		Scanner scan = new Scanner(s);
		TreeSet<String> set = new TreeSet<String>();
		while (scan.hasNext()) {
			set.add(scan.next());
		}
		scan.close();
		return set;
	}
	
	public static String setToString(TreeSet<String> s1) {
		Iterator<String> it = s1.iterator();
		String str = "";
		
		while (it.hasNext()) {
			str += it.next();
			if (it.hasNext()) str += " ";
		}
		
		return str;
	}
	
	public static int wordsInCommon(TreeSet<String> s1, TreeSet<String> s2) {
		TreeSet<String> common = new TreeSet<String>();
		common.addAll(s1);
		common.retainAll(s2);
		return common.size();
	}
	
	public String[] edit(String[] entry) {
		ArrayList<TreeSet<String>> listOfSets = new ArrayList<TreeSet<String>>();
		
		for (int i=0; i<entry.length; i++) {
			// Converts all strings into a list of sets of strings
			listOfSets.add(stringToSet(entry[i]));
		}
		boolean repeatMerge = true;
		
		while (repeatMerge) {
			repeatMerge = false;
			for (int i=0; i<listOfSets.size(); i++) {
				for (int j=i+1; j<listOfSets.size(); j++) {
					TreeSet<String> s1 = listOfSets.get(i);
					TreeSet<String> s2 = listOfSets.get(j);
					
					if (wordsInCommon(s1, s2) >= 2) {
						s1.addAll(s2);
						listOfSets.remove(j);
						repeatMerge = true;
					}
				}
			}
		}
		
		String[] retStrs = new String[listOfSets.size()];
		for (int i=0; i<listOfSets.size(); i++) {
			retStrs[i] = setToString(listOfSets.get(i));
		}
		Arrays.sort(retStrs);
		
		return retStrs;
    }
}
