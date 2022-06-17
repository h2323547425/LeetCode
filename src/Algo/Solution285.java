package Algo;

/**
 * Given the root of a binary search tree and a node p in it, return
 * the in-order successor of that node in the BST. If the given node
 * has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater
 * than p.val.
 */
public class Solution285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode node = root;
        while (node != null) {
            if (p.val >= node.val) {
                node = node.right;
            } else {
                successor = node;
                node = node.left;
            }
        }
        return successor;
    }

}
