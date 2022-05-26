package Algo;

import java.util.List;
import java.util.ArrayList;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer
 * array nums, where all elements are in the inclusive range.
 *
 * A number x is considered missing if x is in the range [lower, upper] and
 * x is not in nums.
 *
 * Return the smallest sorted list of ranges that cover every missing number
 * exactly. That is, no element of nums is in any of the ranges, and each
 * missing number is in one of the ranges.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
public class Solution163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                ranges.add(String.valueOf(lower));
            } else {
                ranges.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return ranges;
        }

        for (int i = 0; i < nums.length; i++) {
            int start;
            if (i == 0) {
                start = lower;
            } else {
                start = nums[i-1] + 1;
            }

            int end = nums[i] - 1;
            if (end == start) {
                ranges.add(String.valueOf(start));
            } else if (end > start) {
                ranges.add(String.valueOf(start) + "->" + String.valueOf(end));
            }
        }

        int leftover = nums[nums.length - 1] + 1;
        if (leftover < upper) {
            ranges.add(String.valueOf(leftover) + "->" + String.valueOf(upper));
        } else if (leftover == upper) {
            ranges.add(String.valueOf(leftover));
        }
        return ranges;
    }

    // alternative range string building method
    public static String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d",n1,n2);
    }
}
