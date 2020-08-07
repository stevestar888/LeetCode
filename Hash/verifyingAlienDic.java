class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] letters = new int[26];
        for (int i = 0; i < 26; i++) {
            letters[order.charAt(i) - 'a'] = i;
        }
        
        String word = words[0];
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < word.length(); j++) {
                //longer words come later
                if (j >= words[i].length()) {
                    return false;
                }
                //same letter, check the next one
                if (word.charAt(j) == words[i].charAt(j)) {
                    continue;
                }
                //if two letters are positioned correctly, no need to check teh rest
                if (isValid(word.charAt(j), words[i].charAt(j), letters)) {
                    break;
                //if two letters are positioned incorrectly, return false immediately
                } else {
                    return false;
                }
            }
            //move on to the next word
            word = words[i];
        }
        return true;
    }
    
    public boolean isValid(char a, char b, int[] letters) {
        return letters[a-'a'] < letters[b-'a'];
    }
}