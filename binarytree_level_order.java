import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * binarytree_level_order
 */



public class binarytree_level_order {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        if(root == null)
            return output;

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> current_level = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }
                current_level.add(current.val);
            }
            output.add(current_level);
            current_level = new ArrayList<>();
        }
        return output;
    }
}