class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        helper(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    
    public void helper(int index, int[] nums, int target, List<Integer> current, List<List<Integer>> ans) { 

        if (target == 0) {
            ans.add(new ArrayList<>(current));
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < nums.length; i++) {
                current.add(nums[i]);
                helper(i, nums, target - nums[i], current, ans);
                current.remove(current.size()-1);
            }
        }
    }
}