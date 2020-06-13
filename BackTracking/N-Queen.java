//Two approaches: one is to actually place the queens (which is much slower)
//and two is to simulate placement by having boolean arrays.

class Solution {
    public int totalNQueens(int n) {
    List<Integer> ans = new ArrayList<>();
    backtrack(new ArrayList<Integer>(), ans, n);
    return ans.size();
}

private void backtrack(List<Integer> currentQueen, List<Integer> ans, int n) {
    if (currentQueen.size() == n) {
        ans.add(1);
        return;
    }
    for (int col = 0; col < n; col++) {
        if (!currentQueen.contains(col)) {
            if (isDiagonalAttack(currentQueen, col)) {
                continue;
            }
            currentQueen.add(col);
            backtrack(currentQueen, ans, n);
            currentQueen.remove(currentQueen.size() - 1);
        }

    }

}

private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
    int current_row = currentQueen.size();
    int current_col = i;
    for (int row = 0; row < currentQueen.size(); row++) {
        if (Math.abs(current_row - row) == Math.abs(current_col - currentQueen.get(row))) {
            return true;
        }
    }
    return false;
}

class Solution {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        return helper(0, n, 0, cols, dia1, dia2);
    }
    
    public int helper(int row, int n, int count, boolean[] cols, boolean[] dia1, boolean[] dia2) {
        if (row == n)
            count++;
        else {
            for (int col = 0; col < n; col++) {
                if (cols[col] || dia1[row+col] || dia2[row-col+n])
                    continue;

                cols[col] = true;
                dia1[row+col] = true;
                dia2[row-col+n] = true;
                count = helper(row+1, n, count, cols, dia1, dia2);
                cols[col] = false;
                dia1[row+col] = false;
                dia2[row-col+n] = false;
            }
        }      
        return count;
    }
}