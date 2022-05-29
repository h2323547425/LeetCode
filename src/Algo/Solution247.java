package Algo;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer n, return all the strobogrammatic numbers that are of
 * length n. You may return the answer in any order.
 *
 * A strobogrammatic number is a number that looks the same when rotated
 * 180 degrees (looked at upside down).
 */
public class Solution247 {

    public static void main(String[] args) {
        Solution247 s = new Solution247();
        System.out.println(s.findStrobogrammatic(1));
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = findStrobogrammaticHelper(n);
        for (int i = res.size() - 1; i >= 0; i--) {
            String s = res.get(i);
            if (s.charAt(0) == '0' && s.length() > 1) {
                res.remove(i);
            }
        }
        return res;
    }

    public List<String> findStrobogrammaticHelper(int n) {
        if (n == 1) {
            return new ArrayList(Arrays.asList("0", "1", "8"));
        }
        if (n == 2) {
            return new ArrayList(Arrays.asList("00", "11", "69", "88", "96"));
        }
        List<String> results = new ArrayList<>();
        List<String> innerList = findStrobogrammaticHelper(n - 2);
        for (String s : innerList) {
            results.add("0" + s + "0");
            results.add("1" + s + "1");
            results.add("8" + s + "8");
            results.add("6" + s + "9");
            results.add("9" + s + "6");
        }
        return results;
    }
}
