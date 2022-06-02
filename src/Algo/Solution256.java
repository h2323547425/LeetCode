package Algo;

/**
 * There is a row of n houses, where each house can be painted one of
 * three colors: red, blue, or green. The cost of painting each house
 * with a certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented
 * by an n x 3 cost matrix costs.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with the
 * color red; costs[1][2] is the cost of painting house 1 with color
 * green, and so on...
 * <p>
 * Return the minimum cost to paint all houses.
 */
public class Solution256 {

    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[] options = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int temp0 = costs[i][0] + Math.min(options[1], options[2]);
            int temp1 = costs[i][1] + Math.min(options[0], options[2]);
            int temp2 = costs[i][2] + Math.min(options[0], options[1]);
            options[0] = temp0;
            options[1] = temp1;
            options[2] = temp2;
        }
        return Math.min(options[0], Math.min(options[1], options[2]));
    }

}
