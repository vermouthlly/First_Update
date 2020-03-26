import java.util.*;

/**
 * top_k_frequent
 */
public class top_k_frequent {

    public static List<Integer> topKFrequent_1(int[] nums, int k) {
        Map<Integer, Integer> book = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for(int i : nums) {
            book.put(i, book.getOrDefault(i, 0) + 1);
        }
        System.out.println(book);
        while(k > 0) {
            int max_value = 0;
            int max_key = 0;
            for (Map.Entry<Integer, Integer> entry : book.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if(value > max_value) {
                    max_key = key;
                    max_value = value;
                }
            }
            answer.add(max_key);
            book.remove(max_key);
            k--;
        }
        return answer;   
    }

    public static List<Integer> topKFrequent_2(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> book = new HashMap<Integer, Integer>();
        for (int i : nums) {
            book.put(i, book.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((i1, i2) -> book.get(i1) - book.get(i2));

        // keep k top frequent elements in the heap
        for (int n : book.keySet()) {
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
        int[] nums = {1,1,1,2,2,3,3,3,3,3,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,10};
        System.out.println(topKFrequent_1(nums, 2));
        System.out.println(topKFrequent_2(nums, 2));
    }
}