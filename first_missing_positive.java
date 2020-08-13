public class first_missing_positive {
    public static int first_miss(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }

        for(int num : nums) {
            int ab = Math.abs(num) - 1;
            if(ab >= len) continue;

            if(nums[ab] > 0) {
                nums[ab] = -nums[ab];
            }
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void main(String args[]) {
        int[] nums = {-2,2,3,4,5,6,7,8,9};
        System.out.println(first_miss(nums));
    }
}