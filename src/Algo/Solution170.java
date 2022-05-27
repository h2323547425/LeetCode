package Algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that accepts a stream of integers and checks
 * if it has a pair of integers that sum up to a particular value.
 *
 * Implement the TwoSum class:
 *
 *  TwoSum() Initializes the TwoSum object, with an empty array initially.
 *
 *  void add(int number) Adds number to the data structure.
 *
 *  boolean find(int value) Returns true if there exists any pair of numbers
 *  whose sum is equal to value, otherwise, it returns false.
 */
public class Solution170 {

    public static class TwoSum {
        Map<Integer, Integer> nums;

        public TwoSum() {
            nums = new HashMap<>();
        }

        public void add(int number) {
            nums.put(number, nums.containsKey(number) ? nums.get(number) + 1 : 1);
        }

        public boolean find(int value) {
            for(int num : nums.keySet()) {
                if(value - num != num) {
                    if(nums.containsKey(value - num)) return true;
                } else {
                    if(nums.get(num) > 1) return true;
                }
            }
            return false;
        }

    }

}
