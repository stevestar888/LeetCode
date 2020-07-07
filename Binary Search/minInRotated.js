class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        if (nums[0] < nums[hi])
            return nums[0];
        
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
        }
        
        return nums[lo];
    }
}