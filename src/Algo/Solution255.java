package Algo;

/**
 * Given an array of unique integers preorder, return true if it is
 * the correct preorder traversal sequence of a binary search tree.
 */
public class Solution255 {

    public boolean verifyPreorder(int[] preorder) {
        return dfs(0, preorder, Integer.MIN_VALUE, Integer.MAX_VALUE) == preorder.length;
    }

    public int dfs(int idx, int[] pre, int lo, int hi){
        if (idx == pre.length || pre[idx] < lo || pre[idx] > hi){
            return idx;
        }
        int val = pre[idx++];
        idx = dfs(idx, pre, lo, val);
        idx = dfs(idx, pre, val, hi);
        return idx;
    }

}
