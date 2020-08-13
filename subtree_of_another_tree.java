/**
 * subtree_of_another_tree
 */
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}

public class subtree_of_another_tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if(equals(s, t)) {
            return true;
        }else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
    public boolean equals(TreeNode x,TreeNode y) {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val == y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
}