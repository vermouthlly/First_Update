import java.util.HashSet;

/**
 * substring_k_distinct
 */
public class substring_k_distinct {

    public static HashSet<String> Distinct_Substring(String s, int k) {
        int[] store = new int[26];
        int num_of_distinct = 0;
        int i = 0;
        HashSet<String> answer = new HashSet<String>();
        for(; i < k; i++) {
            if(store[s.charAt(i) - 'a'] == 0) {
                num_of_distinct++;
            }
            store[s.charAt(i) - 'a']++;
            if(num_of_distinct == k) {
                answer.add(s.substring(0, k));
            }
        }
        for(; i < s.length(); i++) {
            if(store[s.charAt(i) - 'a'] == 0) {
                num_of_distinct++;
            }
            store[s.charAt(i) - 'a']++;
            store[s.charAt(i - k) - 'a']--;
            if(store[s.charAt(i - k) - 'a'] == 0) {
                num_of_distinct--;
            }
            if(num_of_distinct == k) {
                answer.add(s.substring(i - k + 1, i + 1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Distinct_Substring("pqpqs", 2));
    }
}