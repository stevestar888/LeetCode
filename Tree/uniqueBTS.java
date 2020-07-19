class Solution {
    public int numTrees(int n) {
        
        //G(3) = G(1, 3) + G(2, 3) + G(3,3) for example
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) { 
            for (int j = 1; j <= i; j++) { 
                //when we have i nodes
                //and putting number j at the root
                dp[i] += dp[i-j] * dp[j-1];
                //i-j finds the # of placement in the right branch
                //and j-1 finds the # of placement in the left branch
            }
        }
        return dp[n];
    }
}