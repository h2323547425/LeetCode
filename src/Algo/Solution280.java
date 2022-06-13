package Algo;

/**
 * Given an integer array nums, reorder it such that nums[0] <= nums[1]
 * >= nums[2] <= nums[3]....
 *
 * You may assume the input array always has a valid answer.
 */
public class Solution280 {

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        if (nums[0] > nums[1]) {
            swap(nums, 0, 1);
        }
        int idx = 2;
        while (idx < nums.length - 1) {
            if (nums[idx] > nums[idx + 1]) {
                swap(nums, idx, idx + 1);
            }
            if (nums[idx] > nums[idx - 1]) {
                swap(nums, idx - 1, idx);
            }
            idx += 2;
        }
        if (idx == nums.length - 1) {
            if (nums[idx] > nums[idx - 1]) {
                swap(nums, idx, idx - 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
