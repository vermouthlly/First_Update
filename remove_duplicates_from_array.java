import java.util.HashSet;

/**
 * remove_duplicates_from_array
 */
public class remove_duplicates_from_array {

    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int k = 0; k < nums.length; k++) {
            set.add(nums[k]);
        }
        int answer = set.size();
        while(j < nums.length ) {
            if(nums[j - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for(int i  = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}