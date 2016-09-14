import java.util.ArrayList;

public class DrawTree {
  int[] mParents;
  String[] mNames;
  String[] treeRep;
  int count = 0;

  public String[] draw(int[] parents, String[] names) {
    mParents = parents;
    mNames = names;
    treeRep = new String[names.length];
    
    addTerm(findRoot(), -1, "");
    return treeRep;
  }

  public int findRoot() {
    for (int i=0; i<mParents.length; i++) {
      if (mParents[i] == -1) {
        return i;
      }
    }
    return -1; // Error
  }

  public void addTerm(int index, int myParent, String preffix) {
    
    ArrayList<Integer> children = new ArrayList<Integer>();
    boolean hasSiblings = false;
    for (int i=0; i<mParents.length; i++) {
      if (mParents[i] == index) {
        children.add(i);
      }
      if (mParents[i] == myParent && i != index) {
        hasSiblings = true;
      }
    }
    String nodeRep = preffix + "+-" + mNames[index];
    treeRep[count++] = nodeRep;

    for (int i=0; i<children.size(); i++) {
      if (hasSiblings) {
        addTerm(children.get(i), index, preffix+"| ");
      }
      else {
        addTerm(children.get(i), index, preffix+"  ");
      }
    }
    return;    
  }
  
  public static void main(String[] args) {
	  int[] parents = {-1,0,1,1,0,0,5,5};

	  String[] names = {"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};
	  DrawTree dt = new DrawTree();
	  String[] retStr = dt.draw(parents,names);
	  parents[0] = -1;
  }
}
