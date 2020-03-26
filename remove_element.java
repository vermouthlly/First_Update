/**
 * remove_element
 */
public class remove_element {

    public static int removeElement(int[] nums, int val) {
        int m = 0;
        int n = 0;
        int answer = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                answer--;
            }
        }
        while(m < nums.length) {
            if(nums[m] != val) {
                nums[n++] = nums[m];
            }
            m++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        System.out.println(len);
        for(int i  = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}