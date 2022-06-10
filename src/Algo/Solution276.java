package Algo;

/**
 * You are painting a fence of n posts with k different colors. You
 * must paint the posts following these rules:
 *
 * Every post must be painted exactly one color.
 *
 * There cannot be three or more consecutive posts with the same color.
 *
 * Given the two integers n and k, return the number of ways you can
 * paint the fence.
 */
public class Solution276 {

    public int numWays(int n, int k) {
        if (n == 0 || k == 0 || (k < 2 && n > 2)) {
            return 0;
        }
        int nonConsecutiveCount = k;
        int towConsecutiveCount = 0;
        for (int i = 1; i < n; i++) {
            int temp = towConsecutiveCount;
            towConsecutiveCount = nonConsecutiveCount;
            nonConsecutiveCount = (temp + nonConsecutiveCount) * (k - 1);
        }
        return nonConsecutiveCount + towConsecutiveCount;
    }

}
