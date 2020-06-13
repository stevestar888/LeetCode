//my first solution, which is old-fashined modular checking row, col and box separately. 

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!validCol(board, i)) return false;
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (!validRow(board, i)) return false;
        }
        
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3)
                if (!validBox(board, i, j)) return false;
        }
        
        return true;
    }
    
    private boolean validCol(char[][] board, int col) {
        HashSet<Character> seen = new HashSet();
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.') continue;
            if (!seen.contains(board[i][col])) {
                seen.add(board[i][col]);
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean validRow(char[][] board, int row) {
        HashSet<Character> seen = new HashSet();
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == '.') continue;
            if (!seen.contains(board[row][i])) {
                seen.add(board[row][i]);
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean validBox(char[][] board, int row, int col) {
        HashSet<Character> seen = new HashSet();
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if (board[i][j] == '.') continue;
                if (!seen.contains(board[i][j])) {
                    seen.add(board[i][j]);
                } else {
                return false;
                }
            }
        }
        return true;
    }
}

//A clever way of using only one set and utilize strings and the set.add function that returns
//true or false base on whether it added a duplicate to determined if a number already existed
//in "row" or "col" or "box".
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();      
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + "row" + i) ||
                        !seen.add(board[i][j] + "col" + j) ||
                        !seen.add(board[i][j] + "box" + i/3 + j/3))
                        return false;
                }
            }
        }        
        return true;                       
    }
}
