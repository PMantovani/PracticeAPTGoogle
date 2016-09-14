import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BstToLl {
    public ArrayList<LinkedList<TreeNode>> convert(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> listOfLL = new ArrayList<LinkedList<TreeNode>>();
        int level = 0;
        Queue<Entry<TreeNode, Integer>> queue = new LinkedList<Entry<TreeNode, Integer>>();

        if (root == null) return null;

        queue.add(new Entry<TreeNode, Integer>(root, level));
        while (!queue.isEmpty()) {
            Entry<TreeNode, Integer> entry = queue.remove();
            TreeNode node = entry.getKey();
            level = entry.getValue();
            LinkedList<TreeNode> ll;
            if (listOfLL.size() <= level) {
                ll = new LinkedList<TreeNode>();
            }
            else {
                ll = listOfLL.get(level);
            }
            ll.add(node);
            listOfLL.add(level, ll);

            if (node.left != null) {
                queue.add(new Entry<TreeNode, Integer>(node.left, level+1));
            }
            if (node.right != null) {
                queue.add(new Entry<TreeNode, Integer>(node.right, level+1));
            }
        }
        return listOfLL;
    }
    
    public static class Entry<K, V> {
    	private K key;
    	private V value;
    	
    	public Entry(K key, V value) {
    		this.key = key;
    		this.value = value;
    	}
    	public K getKey(){return key;}
    	public V getValue(){return value;}
    }

    public static void main(String[] args) {
    	BstToLl bll = new BstToLl();
    	TreeNode root = new TreeNode();
    	root.data = "2";
    	root.left = new TreeNode();
    	root.left.data = "1";
    	root.right = new TreeNode();
    	root.right.data = "3";
    	ArrayList<LinkedList<TreeNode>> all = bll.convert(root);
    	System.out.print("myy");
    }
}
