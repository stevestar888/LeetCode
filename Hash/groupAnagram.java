class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c-'a']++;
            }
            String val = "";
            for (int num : freq) {
                val += num;
            }
            if (!map.containsKey(val)) {
                map.put(val, new ArrayList());
            } 
            map.get(val).add(s);
        }
        
        return new ArrayList(map.values());
    }
}