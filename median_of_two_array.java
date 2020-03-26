

/**
 * median_of_two_array
 */
public class median_of_two_array {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = findArray(nums1, nums2);
        if(a.length % 2 != 0) {
            return a[(a.length + 1) / 2 - 1];
        }else {
            return (a[a.length / 2 - 1] * 1.0 + a[a.length / 2] * 1.0) / 2;
        }
    }

    public static int[] findArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0) return nums2;
        if(n == 0) return nums1;
        int[] overall = new int[m + n];
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < m && j < n; ) {
            if(nums1[i] <= nums2[j]) {
                overall[k++] = nums1[i++];
            }else {
                overall[k++] = nums2[j++];
            }
        }
        while(i < m) {
            overall[k++] = nums1[i++];
        }
        while(j < n) {
            overall[k++] = nums2[j++];
        }
        return overall;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        int[] num3 = findArray(num1, num2);
        System.out.println(findMedianSortedArrays(num1, num2));
        for(int i = 0; i < 4; i++) {
            System.out.println(num3[i]);
        }
        
    }
}