import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Anagram {

	public boolean isAnagram(String s1, String s2) {
		HashMap<Character,Integer> s1Map = new HashMap<Character,Integer>();
	HashMap<Character,Integer> s2Map = new HashMap<Character,Integer>();
		for (int i=0; i<s1.length(); i++) {
			int count = 0;
	if (s1Map.containsKey(s1.charAt(i))) {
		count = s1Map.get(s1.charAt(i));
	}
	count++;
	s1Map.put(s1.charAt(i), count);
		}
		for (int i=0; i<s2.length(); i++) {
			int count = 0;
	if (s2Map.containsKey(s2.charAt(i))) {
		count = s2Map.get(s2.charAt(i));
	}
	count++;
	s2Map.put(s2.charAt(i), count);
		}

	return s1Map.equals(s2Map);
	}
	
	public static void main(String[] args) {
		Anagram a = new Anagram();
		System.out.println(a.isAnagram("ANAAAA", "NAAAAA"));
	}
}
