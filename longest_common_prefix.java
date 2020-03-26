/**
 * longest_common_prefix
 */
public class longest_common_prefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String beg = strs[0];
        String result = "";
        for(int i = 0; i < beg.length(); i++) {
            boolean flag = true;
            for(int x = 1; x < strs.length; x++) {
                if(strs[x].length() == i) {
                    flag = false;
                    break;
                }
                if(strs[x].charAt(i) != beg.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                result += beg.charAt(i);
            }else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] x = new String[]{"aa", "a"};
        System.out.println(longestCommonPrefix(x));
    }
}