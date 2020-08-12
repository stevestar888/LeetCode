class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];
        
        //first and the last row
        for (int i = 0; i < m; i++) {
            dfs(matrix, 0, i, -1, pacific);
            dfs(matrix, n-1, i, -1, atlantic);
        }
        
        //first and the last col
        for (int i = 0; i < n; i++) {
            dfs(matrix, i, 0, -1, pacific);
            dfs(matrix, i, m-1, -1, atlantic);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(int[][] matrix, int i, int j, int prev, int[][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        
        if (matrix[i][j] < prev || ocean[i][j] == 1) {
            return;
        }
        
        ocean[i][j] = 1;

        dfs(matrix, i+1, j, matrix[i][j], ocean);
        dfs(matrix, i, j+1, matrix[i][j], ocean);
        dfs(matrix, i-1, j, matrix[i][j], ocean);
        dfs(matrix, i, j-1, matrix[i][j], ocean);
        
    }
}
