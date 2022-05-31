package Algo;


/**
 * Given the root of a binary tree, return the number of uni-value subtrees.
 *
 * A uni-value subtree means all nodes of the subtree have the same value.
 */
public class Solution250 {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isUnivalSubtrees(root);
        return count;
    }

    public boolean isUnivalSubtrees(TreeNode root) {
        boolean left = root.left == null || (isUnivalSubtrees(root.left) && root.left.val == root.val);
        boolean right = root.right == null || (isUnivalSubtrees(root.right) && root.right.val == root.val);
        if (left && right ) {
            count++;
            return true;
        }
        return false;
    }

}
