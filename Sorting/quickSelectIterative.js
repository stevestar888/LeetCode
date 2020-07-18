class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length-1;
        k = nums.length - k;
        
        while (lo < hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot < k)
                lo = pivot+1;
            else if (pivot > k) 
                hi = pivot - 1;
            else
                return nums[pivot];
        }
        
        return nums[lo];
    }
    
    public void random(int[] nums, int lo, int hi) {
        Random rand = new Random();
        int randomIndex = lo + rand.nextInt(hi-lo);
        int tmp = nums[lo];
        nums[lo] = nums[randomIndex];
        nums[randomIndex] = tmp;
    }
    
    public int partition(int[] nums, int lo, int hi) {
        //random(nums, lo, hi);
        int pivot = lo;
        while (lo <= hi) {
            while (lo <= hi && nums[pivot] < nums[hi])
                hi--;
            while (lo <= hi && nums[pivot] >= nums[lo]) 
                lo++;
            
            //the two halves are now sorted, no need to swap.
            if (hi < lo)
                break;

            //swap lo and hi becasue the last lo++ or hi++ is out of its range
            int tmp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = tmp;
        }
        
        //once we jump out of this loop, hi is going to be pointing at the lo value; therefore
        //swap it with pivot so pivot is in the right position
        int tmp = nums[pivot];
        nums[pivot] = nums[hi];
        nums[hi] = tmp;
        
        return hi;
    }
}