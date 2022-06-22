package Interview;

import java.util.Arrays;

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

    public int[] twoSum(int[] sums, int target) {
        assert sums.length >= 2;
        Arrays.sort(sums);
        int front = 0;
        int end = sums.length - 1;
        while(front < end) {
            int sum = sums[front] + sums[end];
            if (sum == target) {
                return new int[]{front, end};
            }
            if (sum < target) {
                end--;
            } else {
                front++;
            }
        }
        return null;
    }

}
