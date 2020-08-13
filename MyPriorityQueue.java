/**
 * PriorityQueue
 */
import java.util.*;

public class MyPriorityQueue {
    private ArrayList<Integer> array;

    public MyPriorityQueue() {
        this.array = new ArrayList<Integer>();
    }

    public MyPriorityQueue(ArrayList<Integer> list) {
        this.array = new ArrayList<Integer>(list);
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
        while(index > 0 && array.get(index) < array.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void pushdown(int index) {
        int l = left(index);
        int r = right(index);
        int temp1 = index;
        int temp2 = index;
        int size = array.size();
        if(l < size && array.get(index) > array.get(l)) {
            temp1 = l;
        }
        if(r < size && array.get(index) > array.get(r)) {
            temp2 = r;
        }
        if(temp1 != index && temp2 != index) {
            if(array.get(temp1) >= array.get(temp2)) {
                swap(index, temp2);
                pushdown(temp2);
            }else{
                swap(index, temp1);
                pushdown(temp1);
            }
        }else if(temp1 != index) {
            swap(index, temp1);
            pushdown(temp1);
        }else if(temp2 != index) {
            swap(index, temp2);
            pushdown(temp2);
        }
    }

    public void push(int new_val) {
        array.add(new_val);
        popup(array.size() - 1);
    }

    public int pop() {
        int result = array.get(0);
        int last = array.size() - 1;
        swap(0, last);
        array.remove(last);
        pushdown(0);
        return result;
    }


    public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.push(2);
        pq.push(5);
        pq.push(1);
        pq.push(11);
        pq.push(7);
        pq.push(123);
        pq.push(8);
        pq.push(5);
        for(int i = 15; i > 0; i--) {
            pq.push(i);
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}
