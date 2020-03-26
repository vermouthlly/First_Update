/**
 * longest_palindromic_substring_DP
 */
public class longest_palindromic_substring_DP {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return "";
        boolean[][] table = new boolean[n][n];
        int start = 0, max = 1;
        for(int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i + 1) == s.charAt(i)) {
                table[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }
        for(int k = 3; k <= n; k++) {
            for(int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if(table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if(k > max) {
                        start = i;
                        max = k;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        String s = "abbccccbbasijaiowjklfjskaljdlkjmawiljdlaksfaklsnfkjaskldjalskjdkjasd";
        System.out.println(longestPalindrome(s));
    }
}