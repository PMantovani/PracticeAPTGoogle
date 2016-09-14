import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class AuntUncle {
  HashMap<String, ArrayList<String>> ancMap = new HashMap<String, ArrayList<String>>();
  public String[] list(String[] parents, String target) {
    for (int i=0; i<parents.length; i++) {
      Scanner scan = new Scanner(parents[i]);
      scan.useDelimiter("\\s+");
      ArrayList<String> parentsList = new ArrayList<String>();
      parentsList.add(scan.next());
      parentsList.add(scan.next());
      String person = scan.next();
      ancMap.put(person, parentsList);
      scan.close();
    }
    return getUncleAunt(target);
  }

  public String[] getUncleAunt(String target) {
	ArrayList<String> parents = new ArrayList<String>();
    ArrayList<String> grandparents = new ArrayList<String>();
	if (ancMap.containsKey(target)) {
      parents = ancMap.get(target);
	}
    for (int i=0; i<parents.size(); i++) {
      if (ancMap.containsKey(parents.get(i))) {
        grandparents.addAll(ancMap.get(parents.get(i)));
      }
    }

    HashSet<String> uncleAunt = new HashSet<String>();

    Iterator<Entry<String,ArrayList<String>>> iter = ancMap.entrySet().iterator();
    while (iter.hasNext()) {
      Entry<String,ArrayList<String>> entry = iter.next();
      for (int i=0; i<grandparents.size(); i++) {
        if (entry.getValue().contains(grandparents.get(i))) {
          if (!parents.contains(entry.getKey()) && !entry.getKey().equals(target)) {
            uncleAunt.add(entry.getKey());
          }
        }
      }
    }
    String[] uncles = new String[uncleAunt.size()];
    uncles = uncleAunt.toArray(uncles);
    Arrays.sort(uncles);
    return uncles;
  }
}
