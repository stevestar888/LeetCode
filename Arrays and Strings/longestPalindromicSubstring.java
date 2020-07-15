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

//search from center appraoch: 
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        int left = 0;
        int right = 0;

        for (int i = 1; i< s.length(); i++) {
            int len1 = search(s, i, i);
            int len2 = search(s, i-1, i);
            int len = Math.max(len1, len2);
            
            if (len > right - left + 1) {
                //because i-1 and i are used,
                //the left span will be longer than the right span
                left = i - (len)/2;
                right = i + (len-1)/2;
            }
        }
        return s.substring(left, right+1);
    }
        
    public int search(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }

        return hi - lo - 1;
    }
}