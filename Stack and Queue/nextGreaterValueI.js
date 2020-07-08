class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();
        
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int i = 0;
        for (int num: nums1) {
            if (map.containsKey(num)) {
                nums1[i] = map.get(num);
            } else {
                nums1[i] = -1;
            }
            i++;
        }
        return nums1;
    }
}