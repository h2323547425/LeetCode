package Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and
 * you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[] { numsMap.get(target - nums[i]), i };
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

}
