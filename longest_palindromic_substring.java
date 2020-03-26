/**
 * longest_palindromic_substring
 */
public class longest_palindromic_substring {

    public static String longestPalindrome(String s) {
        String p = change(s);
        int len = p.length();
        int[] radius = new int[len];
        int mx = 0, center = 0;
        for(int i = 1; i < len - 1; i++) {
            int i_mirror = 2 * center - i;
            if(mx > i) {
                radius[i] = Math.min(radius[i_mirror], mx - i);
            }else {
                radius[i] = 0;
            }

            while(p.charAt(i + radius[i] + 1) == p.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }
            if(i + radius[i] > mx) {
                center = i;
                mx = i + radius[i];
            }
        }
        int maxLen = 0, center1 = 0;
        for(int i = 0; i < len - 1; i++) {
            if(radius[i] > maxLen) {
                maxLen = radius[i];
                center1 = i;
            }
        }
        int start = (center1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static String change(String s) {
        String p = "^#";
        if(s.length() == 0) return "^$";
        for(int i = 0; i <  s.length(); i++) {
            p += s.charAt(i);
            p += '#';
        }
        p += '$';
        return p;
    }

    public static void main(String[] args) {
        String s = "abbccccbbasijaiowjklfjskaljdlkjmawiljdlaksfaklsnfkjaskldjalskjdkjasd";
        System.out.println(longestPalindrome(s));
    }
}