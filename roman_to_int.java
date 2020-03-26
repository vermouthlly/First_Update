/**
 * roman_to_int
 */
public class roman_to_int {

    public static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(change(s.charAt(i)) < change(s.charAt(i + 1))) {
                sum -= change(s.charAt(i));
            }else {
                sum += change(s.charAt(i));
            }
        }
        sum += change(s.charAt(s.length() - 1));
        return sum;
    }

    public static int change(char x) {
        if(x == 'I') {
            return 1;
        }
        if(x == 'V') {
            return 5;
        }
        if(x == 'X') {
            return 10;
        }
        if(x == 'L') {
            return 50;
        }
        if(x == 'C') {
            return 100;
        }
        if(x == 'D') {
            return 500;
        }
        if(x == 'M') {
            return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        String x = "MCMXCIV";
        System.out.println(romanToInt(x));
    }
}