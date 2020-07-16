//instead of teh traditional binary search strictly using the index,
//this problem utilizes the range.
//By counting number of elements that are less than the mid(which doesn't necessarily exist in the matrix)
//we know mid is the nth smallest element.
//so essentially keeping doing that until mid == k 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length-1][matrix[0].length-1];
        
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                int row = matrix[0].length - 1;
                while (row >= 0 && matrix[i][row] > mid) {
                    //find the index where elements from this point are less than mid
                    row--;
                }
                count = count + row + 1; 
                //number of elements that are smaller or equal to the mid
            }
            System.out.println(lo + " " + mid + " " + hi + " " + count );
            // if the number of elements are less than k, we need a bigger mid
            // therefore move lo to mid + 1;
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}