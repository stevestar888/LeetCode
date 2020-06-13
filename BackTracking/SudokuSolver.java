class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }
    
    
    public boolean solve(char[][] board, int lastI) {
        for (int i = lastI; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                } else {
                    for (char z = '1'; z <= '9'; z++) {
                        if (isValid(board, i, j, z)) {
                            board[i][j] = z;
                            if (solve(board, i)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if (board[i][col] == c) 
                return false;
            if (board[row][i] == c) 
                return false; 
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) 
                return false;
        }
        return true;
    }
}