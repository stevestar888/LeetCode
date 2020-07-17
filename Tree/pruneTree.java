/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        //a leaf node that's zero gets pruned
        if (root.left == null && root.right == null &&  root.val == 0)
            root = null;
        
        //otherwise return the original node
        return root;
    }
}