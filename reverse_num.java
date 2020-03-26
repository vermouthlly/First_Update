public class reverse_num {
    public static int reverse(int x) {
        boolean neg;
        int tar = 0;
        if (x < 0) {
            neg = true;
            x = Math.abs(x);
        } else {
            neg = false;
        }
        while(x != 0) {
            int curr;
            int test = tar;
            curr = x % 10;
            tar = tar * 10 +  curr;
            x = x / 10;
            if((tar - curr) / 10 != test) {
                return 0;
            }
        }
        if(neg == true) {
            tar = 0 - tar;
            return tar;
        } else {
            return tar;
        }
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
}