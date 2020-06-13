class Solution {
    public List<String> letterCombinations(String digit) {
        List<String> ans = new ArrayList();
        if (digit == null || digit.length() == 0) 
            return ans;
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(0, digit, map, "", ans);
        return ans;
    }
    
    public void helper(int index, String digit, String[] map, String cur, List<String> ans) {
        if (index == digit.length()) {
            ans.add(cur);
        } else {       
            String letters = map[digit.charAt(index) - '0'];     
            for (int i = 0; i < letters.length(); i++) {       
                helper(index+1, digit, map, cur+letters.charAt(i), ans);
            }
        }
    }
}