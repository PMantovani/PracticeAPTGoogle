import java.util.ArrayList;
import java.util.Collections;

public class TheSwap {
  ArrayList<Integer> sortedN;
  int findMax(int n, int k) {
    ArrayList<Integer> origList = findArray(n);

    sortedN = (ArrayList<Integer>) origList.clone();
    Collections.sort(sortedN, Collections.reverseOrder()); // Larger numbers first
    
    int[] origArray = new int[origList.size()];
    for (int i=0; i<origList.size(); i++) {
    	origArray[i] = origList.get(i);
    }

    
    int[] finalIntArray = swap(origArray,k);
    if (finalIntArray.length == 0)
    	return -1;
    
    int finalInt = 0;
    for (int i=0; i<finalIntArray.length; i++) {
    	long mult = (long) Math.pow(10, finalIntArray.length-1-i);
    	finalInt += mult*finalIntArray[i];
    }
    return finalInt;
  }

  public int[] swap(int[] n, int k) {
    int[] swapArray = n; 
    
    if (k==0) { // Base case
    	return n;
    }
    if (n.length == 1) {
    	return new int[] {}; //Empty set represents failure
    }
  
    boolean hasSwapped = false;
    for (int i=0; i<n.length && !hasSwapped; i++) {
      if (swapArray[i] == sortedN.get(i)) //Index already in order
        continue;
      if (swapArray[i] < sortedN.get(i)) {
        for (int j=n.length-1; j>i && !hasSwapped; j--) {
          if (swapArray[j] == sortedN.get(i)) { //Swap
            swapArray[j] = swapArray[i];
            swapArray[i] = sortedN.get(i);
            hasSwapped = true;
          }
        }
      }
    }
    
    // Couldn't make number larger, 
    // first we check to swap equal digits, 
    // if not possible we have to make it smaller, so swap smallest digits
	if(!hasSwapped) {
	  boolean hasSwappedEqualDigits = false;
	  for (int i = 0; i<n.length; i++) {
		  for (int j=i+1; j<n.length; j++) {
			  if (swapArray[i] == swapArray[j]) {
				  hasSwappedEqualDigits = true;
			  }
		  }	  
	  }
	
	  if (!hasSwappedEqualDigits) {
	    //Swap smallest digits
	    int swapTemp = swapArray[swapArray.length-1];
	    swapArray[swapArray.length-1] = swapArray[swapArray.length-2];
	    swapArray[swapArray.length-2] = swapTemp; //Swap numbers in smallest two digits
	  }
	}
	
	if (swapArray[0] == 0 && k==1) {
		return new int[] {};
	}
	
	return swap(swapArray, k-1); //Recursion
      
    }
  
  // Converts number to list of digits
  public ArrayList<Integer> findArray(int n) {
    String strN = ""+n;
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i=0; i<strN.length(); i++) {
    	list.add((int)strN.charAt(i)-48);
    }
    return list;
  }
  
  public static void main(String[] args) {
	  TheSwap c = new TheSwap();
	  System.out.println(c.findMax(436659, 2));
  }
}
