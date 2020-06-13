class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(nums, new ArrayList<>(), ans);
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> current, List<List<Integer>> ans) {         System.out.println(current);
        if (current.size() == nums.length) {
            ans.add(new ArrayList<Integer>(current));     
        } else {
            for (int i = 0; i < nums.length; i++ ) {
                if (current.contains(nums[i])) {
                    continue;
                } else {
                    current.add(nums[i]);
                    helper(nums, current, ans);
                    current.remove(current.size()-1);
                }
            }
        }
    }
}