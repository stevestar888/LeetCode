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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> route = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int count = 0;
        
        while (!stack.isEmpty() || cur != null) {
            
            while (cur != null) {
                count += cur.val;
                stack.push(cur);
                route.add(cur.val);
                cur = cur.left;
            }
            //reach the left bottom;
            
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                //cur.rigth == pre meaning we are done visitng both cur's children
                cur = cur.right;
                continue;
            }
            
            if (count == sum && cur.left == null && cur.right == null) {
                ans.add(new ArrayList<Integer>(route));
            }
            
            pre = cur;
            stack.pop();
            count -= cur.val;
            route.remove(route.size()-1);
            cur = null;
        }
        
        return ans;
        
    }
}