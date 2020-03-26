/**
 * Palindrome
 */
public class Palindrome {

    public static boolean isPalindrome(int x) {
        int tar = 0;
        int flag = x;
        if(x < 0) {
            return false;
        } else if(x == 0) {
            return true;
        }
        while(x != 0) {
            tar = tar * 10 + x % 10;
            x = x / 10;
        }
        if( tar == flag) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}