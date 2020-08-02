class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c-'A']++;
        }
        
        Arrays.sort(freq);
        int mostFreq = freq[25];
        int frame = (mostFreq - 1) * n;//LAST ONE DOESN'T COUNT
        
        for (int i = freq.length - 2; i >= 0 && frame > 0; i--) {
            frame -= Math.min(mostFreq - 1, freq[i]);
        }
        
        return frame < 0 ? tasks.length : frame + tasks.length;
        //if the frame is filled or more, ie: 0, then the ans would just be the total number of tasks.
        //if the frame is not filled, meaning not enough tasks exist to allow cool down time, then extra idle time are required, therefore adding the number of spots left in frame to tatal number of tasks.
        
        
    }
}