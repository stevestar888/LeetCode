class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, int row, int col, int index, String word) {
        if (index == word.length())
            return true;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index))
            return false;
        
        char tmp = board[row][col];
        board[row][col] = ' ';
        
        if (helper(board, row+1, col, index+1, word) 
            || helper(board, row-1, col, index+1, word) 
            || helper(board, row, col+1, index+1, word) 
            || helper(board, row, col-1, index+1, word))
            
            return true;
        
        board[row][col] = tmp;
        
        return false;
    }
}