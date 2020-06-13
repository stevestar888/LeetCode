//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

//DP Approach using 2D array
//O(n^2) of space complexity is not ideal; can be improved
//using expand from the middle technique.

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean table[][] = new boolean[n][n]; 
        int count = 0;
        int start = 0;

        //palindromes with length 1 base (aba)
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
            count = 1;
        } 

        //palindromes with length 2 base (baab)
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                count = 2;
                start = i;
            }
        }

        //palindromes with length 3 or more
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n-k+1; ++i) {
                int j = i + k - 1;
                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if (k > count) {
                        start = i;
                        count = k;
                    }
                }
            }
        }
        return s.substring(start, start+count);
    }
}