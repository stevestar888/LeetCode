//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

//use the first col and row as indicators for any zeros in each col and row;
//find the zeros first and then set the cols and rows to zeros
class Solution {
    public void makeRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    
    public void makeCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {   
        boolean hasRow = false;
        boolean hasCol = false;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        //first row
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                hasRow = true;
                break;
            }
        }
        
        //first col
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                hasCol = true;
                break;
            }
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0)
                makeRow(matrix, i);
        }
        
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0)
                makeCol(matrix, i);
        }
        
        if (hasRow) makeRow(matrix, 0);
        if (hasCol) makeCol(matrix, 0);
    }
}
