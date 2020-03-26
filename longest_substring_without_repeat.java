import java.util.HashSet;

/**
 * longest_substring_without_repeat
 */
public class longest_substring_without_repeat {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdefabcdabcff";
        System.out.println(lengthOfLongestSubstring(s));
    }
}