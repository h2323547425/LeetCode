package Algo;

/**
 * Given the root of a binary search tree and a target value, return
 * the value in the BST that is closest to the target.
 */
public class Solution270 {

    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        int closest = root.val;
        while(true) {
            if (target < curr.val && curr.left != null) {
                curr = curr.left;
            } else if (target > curr.val && curr.right != null) {
                curr = curr.right;
            } else {
                break;
            }
            if (Math.abs(target - curr.val) < Math.abs(target - closest)) {
                closest = curr.val;
            }
        }
        return closest;
    }

}
