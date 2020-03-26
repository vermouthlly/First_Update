import java.util.HashSet;

/**
 * subarray_with_k_integer
 */
public class subarray_with_k_integer {

    public static int subarraysWithKDistinct(String s, int K) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < s.length() - K + 1; i++) {
            set.removeAll(set);
            for(int j = i; j < s.length(); j++) {
                if(set.size() == K && !set.contains(s.charAt(j))) {
                    break;
                }
                if(set.size() < K) {
                    set.add(s.charAt(j));
                }
                if(set.size() == K && set.contains(s.charAt(j))) {
                    count++;
                }
            }

        } 
        return count;
    }

    public static void main(String[] args) {
        String A = "pqpqs";
        String B = "aabab";
        System.out.println(subarraysWithKDistinct(A, 2));
        System.out.println(subarraysWithKDistinct(B, 3));
    }
}