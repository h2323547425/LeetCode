package Algo;

/**
 * There are a row of n houses, each house can be painted with one of the
 * k colors. The cost of painting each house with a certain color is
 * different. You have to paint all the houses such that no two adjacent
 * houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by
 * an n x k cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 *
 * Return the minimum cost to paint all houses.
 */
public class Solution265 {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int prevMin = 0, prevSecMin = 0;
        int prevMinIndex = -1;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == prevMinIndex ? prevSecMin : prevMin);
                if (cost < min) {
                    secMin = min;
                    min = cost;
                    minIndex = j;
                } else if (cost < secMin) {
                    secMin = cost;
                }
            }
            prevMin = min;
            prevSecMin = secMin;
            prevMinIndex = minIndex;
        }
        return prevMin;
    }

}
