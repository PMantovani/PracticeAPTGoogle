public class CheckBalance {
    int min = 9999;
    int max = 0;
    public boolean isBalanced(TreeNode root) {
        checkTree(root, 0);

        if ((min+1) < max) { //If root==null, returns true
            return false;
        }
        else {
            return true;
        }
    }
    public void checkTree(TreeNode root, int level) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (level > max) max = level;
            if (level < min) min = level;
        }
        else {
            checkTree(root.left, level+1);
            checkTree(root.right, level+1);
        }
        return;
    }
}
