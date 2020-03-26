/**
 * str
 */
public class str {

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        while(i < len1) {
            if(len1 - i < len2){
                return -1;
            }else if(haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abcda";
        String needle = "cd";
        System.out.println(strStr(haystack, needle));
    }
}