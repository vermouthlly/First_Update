import java.util.*;

/**
 * n_array_topk
 */

public class n_array_topk {

    public static class Node {
        int val;
        int Index;
        int index;
        Node(int v, int I, int i) {
            val = v;
            Index = I;
            index = i;
        }
        public void print() {
            System.out.println(val);
            System.out.println(index);
        }
    }

    public static ArrayList<Integer> top(ArrayList<ArrayList<Integer>> input, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(input.size(), (Node n1, Node n2) -> n2.val - n1.val);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < input.size(); i++) {
            ArrayList<Integer> nums = input.get(i);
            Node temp = new Node(nums.get(0), i, 0);
            pq.add(temp);
        }

        int counter = 0;
        while(counter < K) {
            Node temp = pq.poll();
            result.add(temp.val);
            if(temp.index < input.get(temp.Index).size() - 1) {
                int target = input.get(temp.Index).get(temp.index + 1);
                Node t = new Node(target, temp.Index, temp.index + 1);
                pq.add(t);
            }
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, 9, 8, 7));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11, 6, 5, 3));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(20, 14, 13, 12));
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        total.add(a);
        total.add(b);
        total.add(c);
        System.out.println(top(total, 3));
    }
}