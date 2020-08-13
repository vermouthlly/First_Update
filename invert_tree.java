import java.util.*;

public class invert_tree {
    public class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x; }
    }

    public static Node invertTree(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> book = new LinkedList<>();

        book.offer(root);
        while(!book.isEmpty()) {
            Node cur = book.poll();
            Node temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null) {
                book.offer(cur.left);
            }
            if(cur.right != null) {
                book.offer(cur.right);
            }
        }

        return root;
    }
}