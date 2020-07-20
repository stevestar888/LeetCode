/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        //create an undirected graph in adjcency list form
        buildGraph(map, root);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(target.val);
        Set<Integer> seen = new HashSet();
        int level = 0;
        
        List<Integer> ans = new ArrayList();
        while (level != K) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (seen.contains(cur)) {
                    continue;
                }
                seen.add(cur);
                for (int nei : map.get(cur)) {
                    if (!seen.contains(nei)) {
                        q.add(nei);
                    }
                }
            }
            level++;
        }
        ans.addAll(q);
        return ans;
        
        
    }
    
    public void buildGraph(HashMap<Integer, List<Integer>> map, TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        map.put(root.val, new ArrayList<Integer>());
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
  
                if (cur.left != null) {
                    q.offer(cur.left);
                    //connect children to the parent
                    map.get(cur.val).add(cur.left.val);
                    //connect the parent to the child
                    map.put(cur.left.val, new ArrayList<Integer>());
                    map.get(cur.left.val).add(cur.val);
                }
                
                if (cur.right != null) {
                    q.offer(cur.right);
                    //connect children to the parent
                    map.get(cur.val).add(cur.right.val);
                    //connect the parent to the child
                    map.put(cur.right.val, new ArrayList<Integer>());
                    map.get(cur.right.val).add(cur.val);
                }
            }
        }
    }
}
