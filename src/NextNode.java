public class NextNode {
    public TreeNode findNext(TreeNode n) {
        TreeNode temp;
        if (n.right != null) {
            temp = n.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;  //Return leftmost child of right child
        }
        else {
            temp = n;
            if (temp.parent == null)
                return null; //If last element and root, return null
            while (!temp.parent.left.equals(temp)) {
                temp = temp.parent;
                if (temp.parent == null)
                    return null; //If last element, return null
            }
            return temp; // Return next larger parent
        }
    }
}

/*
                8
     4                  12
 2      6           10      14
1 3    5 7         9  11   13 15
*/
