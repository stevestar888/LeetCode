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

// finding right child index in preorder array: 
// index of current node in the preorder array: pre
// pre order traversal: ( root -> left -> ... -> right), to get to the right child  we need to skipp all the node on the left branches/subtrees of current node
// The inorder array has this information exactly. the index of root in "inorder" array is known from the for loop
// Therefore the immediate right child index is pre + nodesOnLeft + 1 
// nodesOnLeft = mid - in1.
// THEREFORE PRE + MID - IN1 + 1
                                                                        
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return search(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode search(int[] preorder, int[] inorder, int pre, int in1, int in2) {
        if (pre >= preorder.length || in2 < in1) 
            return null;
        
        TreeNode root = new TreeNode(preorder[pre]);
        int mid = 0;
        for (int i = in1; i <= in2; i++) {
            if (inorder[i] == root.val) {
                mid = i;
            }
        }
        
        root.left = search(preorder, inorder, pre+1, in1, mid-1);
        root.right = search(preorder, inorder, pre+mid-in1+1, mid+1, in2);
        
        return root;
    }
}