/**
 * quicksort
 */
public class quicksort {

    public static void qs(int[] num, int low, int high) {
        if(low > high) {
            return;
        }
        int i = low;
        int j = high;
        int pivot = num[i];
        
        while(i < j) {
            while(i < j && num[j] >= pivot) {
                j--;
            }
            if(i < j) {
                num[i] = num[j];
                i++;
            }
            while(i < j && num[i] < pivot) {
                i++;
            }
            if(i < j) {
                num[j] = num[i];
                j--;
            }
        }
        num[i] = pivot;
        qs(num, low, i - 1);
        qs(num, i + 1, high);
    }

    public static void main(String[] args) {
        int[] num = {1,6,3,1,2,5,5,8,9,3};
        qs(num, 0, 9);
        for(int i : num) {
            System.out.println(i);
        }
        
    }
}