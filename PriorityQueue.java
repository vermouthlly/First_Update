/**
 * PriorityQueue
 */
import java.util.*;

public class PriorityQueue {
    private ArrayList<Integer> array;

    public PriorityQueue() {
        array = new ArrayList<Integer>();
    }

    public PriorityQueue(ArrayList<Integer> list) {
        array = new ArrayList<Integer>(list);
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    private void popup(int index) {
        while(index > 0 && array.get(index) > array.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void pushdown(int index) {
        int l = left(index);
        int r = right(index);
        int temp = index;
        int size = array.size();
        if(l < size && array.get(index) < array.get(l)) {
            temp = l;
        }
        if(r < size && array.get(index) < array.get(r)) {
            temp = r;
        }
        if(temp != index) {
            swap(index, temp);
            pushdown(temp);
        }
    }

    public void push(int new_val) {
        array.add(new_val);
        popup(array.size() - 1);
    }

    public int pop() {
        int result = array.get(0);
        int last = array.size() - 1;
        array.set(0, array.get(last));
        array.remove(last);
        pushdown(0);
        return result;
    }


    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(2);
        pq.push(5);
        pq.push(1);
        pq.push(11);
        pq.push(7);
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
    }
}
