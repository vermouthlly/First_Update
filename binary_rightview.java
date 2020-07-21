/**
 * binary_rightview
 */
public class binary_rightview {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static int height = 0;

    public static void right(TreeNode root, int now) {
        if(root == null) {
            return;
        }
        
        if(now == height) {
            System.out.println(root.val);
            height++;
        }
        right(root.right, now + 1);
        right(root.left, now + 1);
    }
}