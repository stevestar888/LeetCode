class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        
        //first loop fills up the dp table with values in the last row
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + cur.get(j);
            }
        }
        
        return dp[0];
        
    }
}