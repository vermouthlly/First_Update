import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * top_k_frequent
 */
public class top_k_frequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Map<Integer, Integer> book = new HashMap<>();
        // List<Integer> answer = new ArrayList<>();
        // for(int i : nums) {
        //     book.put(nums[i], book.getOrDefault(nums[i], 0) + 1);
        // }
        // while(k > 0) {
        //     int max_value = 0;
        //     int max_key = 0;
        //     for (Map.Entry<Integer, Integer> entry : book.entrySet()) {
        //         int key = entry.getKey();
        //         int value = entry.getValue();
        //         if(value > max_value) {
        //             max_key = key;
        //             max_value = value;
        //         }
        //     }
        //     answer.add(max_key);
        //     book.remove(max_key);
        //     k--;
        // }
        // return answer;
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new ArrayList<>();
        while (!heap.isEmpty())
            top_k.add(heap.poll());

        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));
    }
}