/**
 * duplicate_num
 */
public class duplicate_num {

    public int findDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i = 0; i < nums.length; i++) {
            int m = nums[Math.abs(nums[i])];
            if(m > 0) {
                nums[Math.abs(nums[i])] = 0 - nums[Math.abs(nums[i])];
            }else {
                return Math.abs(nums[i]);
            }
        }
        return -1;
    }
}