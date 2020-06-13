//Tortois and Hare Algorithm (detecting cycles)
//Only linear time and constant space required

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        
        int slow2 = nums[0];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}