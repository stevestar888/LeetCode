class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int unhappyCus = 0;
        int maxUnhappy = 0;  
        int total = 0;
        
        for (int i = 0; i < grumpy.length; i++) {
            boolean isGrumpy = grumpy[i] == 1;
            int numCust = customers[i];
            //calculate sum
            if (!isGrumpy) {
                total += numCust;
            }
            
            //extend if grumpy
            if (isGrumpy) {
                unhappyCus += numCust;
            }
            
            //close in the window
            if (i >= X && grumpy[i-X] == 1) {
                unhappyCus -= customers[i-X];
            }
            
            //update
            if (unhappyCus > maxUnhappy) {  
                maxUnhappy = unhappyCus;
            }
        }
        
        return maxUnhappy + total;
    }
}