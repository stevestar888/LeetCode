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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> ans = new ArrayList();
        
        while (!stack.isEmpty() || root != null) {
            //go all the way down to the left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.peek();
            //if right child exist, go there.
            if (cur.right != null) {
                root = cur.right;
            } else {
                //if no right child, add cur, but make sure to also go back up if this 
                //is teh right subtree because it's a deadend. 
                ans.add(stack.pop().val);
                while (!stack.isEmpty() && cur == stack.peek().right) {
                    cur = stack.pop();
                    ans.add(cur.val);
                }
            }
        }
        return ans;
    }
}