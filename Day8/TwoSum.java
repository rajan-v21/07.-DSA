import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] result = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
