class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        dp[0][0] = true; //empty == empty
        
        //if regex starts with *, it could be representing nothing, so preset it to true
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char og = s.charAt(i-1);
                char rg = p.charAt(j-1);
                if (rg == '*') {
                  // dp[i-1][j] represents insert, or more than one char
                  //dp[i][j-1] represents remove, or empty char
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                  //replace, but have to make sure everything before the replacement matches
                    dp[i][j] = dp[i-1][j-1] && (rg == '?' || rg == og);
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}