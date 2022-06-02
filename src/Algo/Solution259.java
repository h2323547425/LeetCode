package Algo;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find
 * the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 */
public class Solution259 {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] < target - nums[i]) {
                    sum += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return sum;
    }

}
