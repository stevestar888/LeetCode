class Solution {
  public void jumpGame() {
    
    int[][] input = {{1, 17}, {2, 2}, {3, 100}, {1, 87}, {1, 33}, {1, 14}};
    
    int[] dp = new int[input.length];
    Arrays.fill(dp, Integer.MAX_VALUE);    
    dp[0] = input[0][1];
    
    for (int i = 1; i < input.length; i++) {
      dp[i] = Math.min(dp[i], input[i][1] + dp[i-1]);
      for (int j = 1; j <= input[i][0]; j++) {
        int travelTo = i + j;
        if (travelTo >= input.length) {
          travelTo = input.length-1;
        }
        dp[travelTo] = Math.min(dp[travelTo], dp[i] + input[travelTo][1]);
      }
    }
    
    for (int num : dp) {
      System.out.println(num);
    }
    System.out.println(dp[dp.length-1]);
  }
}