class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        
        sum /= 2;
        
        Boolean[][] dp = new Boolean[nums.length + 1][sum + 1];

        Arrays.fill(dp[0], false);

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }
        
        return dp[nums.length][sum];
    }
}