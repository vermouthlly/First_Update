public class minimum_absolute_value {
    public static int find(int[] num) {
        if(num == null || num.length == 0) {
            return -1;
        }

        int low = 0;
        int high = num.length - 1;
        int middle = 0;
        while(low <= high) {
            middle = (low + high) / 2;
            if(num[middle] < 0) {
                if(num[middle + 1] >= 0) {
                    return -num[middle] <= num[middle + 1] ? -num[middle] : num[middle + 1];
                }else {
                    low = middle;
                }
            }else if(num[middle] > 0) {
                if(num[middle - 1] <= 0) {
                    return -num[middle - 1] <= num[middle] ? -num[middle - 1] : num[middle];
                }else {
                    high = middle;
                }
            }else
                return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {-7, -3, -2, 3, 4, 8, 16, 17};
        System.out.println(find(a));
    }
}