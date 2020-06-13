//Kodane's Algorithm;
//if previous sum adding current num is less than current
//num, than there is no point of taking the previous sum, and 
//just start over from current num.

class Solution {
    public int maxSubArray(int[] nums) {
        int prev_sum = nums[0];
        int max_sum = prev_sum;
        for (int i = 1; i < nums.length; i++) {
            prev_sum = Math.max(prev_sum + nums[i], nums[i]);
            max_sum = Math.max(prev_sum, max_sum);
        }
        return max_sum;
    }
}