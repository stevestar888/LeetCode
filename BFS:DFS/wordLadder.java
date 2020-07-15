class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        
        if (!set.contains(endWord)) {
            return 0;
        }
        
        int level = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {        
                String curWord = q.poll();
                char[] curChars = curWord.toCharArray();
                for (int j = 0; j < curWord.length(); j++) {
                    char og = curChars[j];
                    for (char l = 'a'; l <= 'z'; l++) {
                        if (curChars[j] == l) {
                            continue;
                        }
                        curChars[j] = l;
                        String modified = String.valueOf(curChars);
                        if (modified.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(modified)) {
                            System.out.println(modified);
                            q.offer(modified);
                            set.remove(modified);
                        }
                        curChars[j] = og;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}