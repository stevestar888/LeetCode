class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) 
            return 0;
        
        int ans = 0;
        int preLeft = 0;
        int preRight = 0;
        
        int lo = 0;
        int hi = height.length-1;
        
        while (lo < hi) {
            int left = height[lo];
            int right = height[hi];
            
            if (left < right) {
                if (left < preLeft) {
                    ans += preLeft - left;
                } else {
                    preLeft = left;
                }
                lo++;
            } else {
                if (right < preRight) {
                    ans += preRight - right;
                } else {
                    preRight = right;
                }
                hi--;
            }
        }
        return ans;
    }
    
    
}