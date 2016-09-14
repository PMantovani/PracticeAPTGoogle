import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Zoo {
  int[] order;
  

  public long theCount(int[] answers) {
    Arrays.sort(answers);
    order = answers;

    HashSet<Integer> cats = new HashSet<Integer>();
    HashSet<Integer> rabbits = new HashSet<Integer>();
    return insertToSet(0, cats, rabbits);  
  }

  public long insertToSet(int index, HashSet<Integer> cats, HashSet<Integer> rabbits) {
    boolean canIncludeInCats = true;
    boolean canIncludeInRabbits = true;
    if (index>order.length-1) {
    	if ((cats.size()+rabbits.size())==order.length) {
            return 1;
          }
      return 0;
    }
    int myHeight = order[index];
    for (int i=myHeight-1; i>=0; i--) {
      if (!cats.contains(i)) {
        canIncludeInCats = false;
      }
      if (!rabbits.contains(i)) {
        canIncludeInRabbits = false;
      }
    }
    if (cats.contains(myHeight)) {
      canIncludeInCats = false;
    }
    if (rabbits.contains(myHeight)) {
      canIncludeInRabbits = false;
    }

    long countComb = 0;
    if (canIncludeInCats) {
      cats.add(myHeight);
      countComb += insertToSet(index+1, cats, rabbits);
      cats.remove(myHeight);
    }
    if (canIncludeInRabbits) {
      rabbits.add(myHeight);
      countComb += insertToSet(index+1, cats, rabbits);
      rabbits.remove(myHeight);
    }
    return countComb;
  }
  
  public static void main(String[] args) {
	Zoo z = new Zoo();
	System.out.println(z.theCount(new int[] 		
			{0, 1}
));
  }
}
