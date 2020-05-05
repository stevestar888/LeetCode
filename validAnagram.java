//utilize the ASCII numbers of letters
//create an array of length 26 and fill up with number of times
//each letter appeared, and subtract wihle it appears in the second 
//String. Check if the array is empty.

//O(n) time
//bascially O(1) space becase we only need an array with length 26

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
         }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}