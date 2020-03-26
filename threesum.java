import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3sum
 */
public class threesum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[j] + nums[k] < target) {
                    j++;
                }else if(nums[j] + nums[k] > target) {
                    k--;
                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!answer.contains(temp)) {
                        answer.add(temp);
                    }
                    j++;
                    k--;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}