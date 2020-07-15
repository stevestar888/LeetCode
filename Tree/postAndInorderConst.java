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

//same as #105, instead using hashmap to store all nodes to avoid the for loop linear time lookup

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> roots = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            roots.put(inorder[i], i);
        }
        return search(inorder, postorder, postorder.length-1, 0, inorder.length-1, roots);
    }
    
    public TreeNode search(int[] inorder, int[] postorder, int post, int in1, int in2, Map<Integer, Integer> roots) {
        if (post < 0 || in1 > in2) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[post]);
        int mid = roots.get(root.val);
        
        root.left = search(inorder, postorder, post-in2+mid-1, in1, mid-1, roots);
        root.right = search(inorder, postorder, post-1, mid+1, in2, roots);
        
        return root;
    }
}