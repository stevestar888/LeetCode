class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            } else {
                dp[0][i] = false;
            }
        }
        
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2]; //zero times of the previous letter (-2)
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                        //if decided to use it mutilpe time, the previous letter has
                        //to match the original string at that char index (or '.')
                        //if matches, we go up, because up represents checking 
                        //if previous substruings are matched not looking at the current macth up
                    }
                } else if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    //if they do match or '.', obviously just go up and left because that has the answer to
                    // whether the previous substrings match
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //if they don't match or no regex exists, that has to be false;
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}