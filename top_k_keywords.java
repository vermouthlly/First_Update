import java.util.*;

public class top_k_keywords {
    public static List<String> top(int k, String[] keywords, String[] review) {
        Map<String, Integer> book = new HashMap<>();
        for(String s : review) {
            s = s.toLowerCase();
            for(String target : keywords) {
                if(s.contains(target)) {
                    book.put(target, book.getOrDefault(target, 0) + 1);
                }
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {    
                int val1 = book.get(s1);
                int val2 = book.get(s2);
                if(val1 != val2) {
                    return val2 - val1;
                }else {
                    return s1.compareTo(s2);
                }
            }
        });

        heap.addAll(book.keySet());
        List<String> answer = new ArrayList<>();
        while(!heap.isEmpty() && k > 0) {
            answer.add(heap.poll());
            k--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        
        int k3 = 5;
        String[] keywords3 = { "a", "b", "c", "d", "e" };
        String[] reviews3 = {"abcde", "b", "d", "d"};
        System.out.println(top(k1, keywords1, reviews1));
        System.out.println(top(k2, keywords2, reviews2));
        System.out.println(top(k3, keywords3, reviews3));
    }
}