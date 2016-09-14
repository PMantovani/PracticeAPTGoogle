public class TreeNode implements Comparable<TreeNode>{
    	public TreeNode left;
    	public TreeNode right;
    	public String data;
    	public TreeNode parent;
    	
    	public TreeNode(TreeNode left, TreeNode right, String data) {
    		this.left = left;
    		this.right = right;
    		this.data = data;
    	}

		@Override
		public int compareTo(TreeNode arg0) {
			return arg0.data.compareTo(this.data);
		}
}