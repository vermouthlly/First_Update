/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
import java.util.*;

public class LRU {
    public class Node {
        int key, val;
        Node pre, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> book;
    private Node head;
    private Node tail;
    int count;
    int capacity;

    public LRU(int capacity) {
        book = new HashMap<>(capacity);

        this.count = 0;
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.pre = null;

        tail.next = null;
        tail.pre = head;
    }

    private void addNode(Node new_insert) {
        new_insert.pre = this.head;
        new_insert.next = this.head.next;
        this.head.next.pre = new_insert;
        this.head.next = new_insert;
    }

    private void Move_to_head(Node cur) {
        Node prev = cur.pre;
        Node next = cur.next;
        prev.next = next;
        next.pre = prev;

        addNode(cur);
    }

    public int get(int key) {
        if(!book.containsKey(key)) {
            return -1;
        }

        Node cur = book.get(key);
        Move_to_head(cur);

        return cur.val;
    }
    
    public void put(int key, int value) {
        if(book.containsKey(key)) {
            Node cur = book.get(key);
            cur.val = value;
            Move_to_head(cur);
        }else {
            Node new_insert = new Node(key, value);
            book.put(key, new_insert);
            if(count < capacity) {
                addNode(new_insert);
                count++;
            }else {
                book.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                
                addNode(new_insert);
            }
        }
    }
}