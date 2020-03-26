import java.util.HashMap;

/**
 * two_sum
 */
public class two_sum {

    public static int[] twoSum(int[] nums, int target) {
        int tar;
        int[] result = new int[2];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            tar = target - nums[i];
            if(m.containsKey(tar)) {
                result[0] = m.get(tar);
                result[1] = i;
                return result;
            }
            m.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] n = {1,5,6,8,9,20};
        int target = 15;
        System.out.println(twoSum(n, target)[0] + " and " + twoSum(n, target)[1]);
    }
}
