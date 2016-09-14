import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class SortedFreqs {

  public int[] freqs(String[] data) {
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    TreeSet<String> setOfData = new TreeSet<String>();

    // Add all data to the set
    for(String dataItem : data) { // Takes O(N), counts frequencies
      int freq = 0;
      if(map.containsKey(dataItem)) {
        freq = map.get(dataItem);
      }
      map.put(dataItem, freq+1); // Map will contain Word->Frequency assoc.
      setOfData.add(dataItem); // Set will remove duplicates while maintaining 
                               // insertion order
    }
    
    int[] freq = new int[setOfData.size()]; // Declares array of freqs
    Iterator<String> iter = setOfData.iterator();
    int i = 0;
    while (iter.hasNext()) {
      freq[i++] = map.get(iter.next());
    }
    return freq;
  }
}
