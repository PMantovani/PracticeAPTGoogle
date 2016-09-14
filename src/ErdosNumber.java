import java.util.*;
import java.util.Map.Entry;

public class ErdosNumber {
  ArrayList<String> output = new ArrayList<String>();
  HashSet<String> visited = new HashSet<String>();
  HashMap<String,ArrayList<String>> authorsMap = new HashMap<String,ArrayList<String>>();

  public String[] calculateNumbers(String[] pubs) {
    HashSet<String> allAuthors = new HashSet<String>();

    for (int i=0; i<pubs.length; i++) {
      String[] authors = pubs[i].split("\\s+");
      allAuthors.addAll(Arrays.asList(authors));
      for (int j=0; j<authors.length; j++) {
        ArrayList<String> coAuthors = new ArrayList<String>();
        if (authorsMap.containsKey(authors[j])) {
          coAuthors = authorsMap.get(authors[j]);  
        }
        coAuthors.addAll(Arrays.asList(authors));
        coAuthors.remove(authors[j]);
        authorsMap.put(authors[j], coAuthors);
      }
    }

    Queue<AbstractMap.SimpleEntry<String, Integer>> queue = 
    		new LinkedList<AbstractMap.SimpleEntry<String, Integer>>();
    queue.add(new AbstractMap.SimpleEntry<String, Integer>("ERDOS", 0));
    while(!queue.isEmpty()) {
      Entry<String, Integer> entry = queue.remove();
      int level = entry.getValue();
      String name = entry.getKey();
      if (!visited.contains(name)) {
        visited.add(name);
        output.add(name + " " + level);
        for (String coauth : authorsMap.get(name)) {
          queue.add(new AbstractMap.SimpleEntry<String, Integer>(coauth, level+1));
        }
      }
    }
    allAuthors.removeAll(visited);
    for (String leftAuth : allAuthors) {
      output.add(leftAuth);
    }
    String[] outputStrVec = new String[output.size()];
    outputStrVec = output.toArray(outputStrVec);
    Arrays.sort(outputStrVec);
    return outputStrVec;
  }
}
