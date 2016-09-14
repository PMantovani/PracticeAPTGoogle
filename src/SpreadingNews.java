import java.util.ArrayList;
import java.util.Collections;

class SpreadingNews {
  int[] sup;

  public int informAndCount(int index) {
    ArrayList<Integer> counts = new ArrayList<Integer>();
    for (int i=index; i<sup.length; i++) {
      if (sup[i] == index)
        counts.add(informAndCount(i));
    }
    // needs to check if counts has something in it
    
    if (counts.size() == 0) { // Base case, not a supervisor of anyone
    	return 0;
    }
    
    Collections.sort(counts, Collections.reverseOrder());
    
    // Time of max child is now at counts.get(0)
    int max = counts.get(0) + 1;
    for (int i=1; i<counts.size(); i++) {
    	int totalTimeForChild = counts.get(i) + (i+1);
    	if (totalTimeForChild > max) {
    		max = totalTimeForChild;
    	}
    }
    return max;    
  }

  public int minTime(int[] supervisors) {
    sup = supervisors;
    return informAndCount(0);
  }

}