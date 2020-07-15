class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) 
            return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    
    public void dfs(int[][] image, int row, int col, int og, int newColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length)
            return;
        
        if (image[row][col] != og) 
            return;
        
        image[row][col] = newColor;
        
        dfs(image, row+1, col, og, newColor);
        dfs(image, row, col+1, og, newColor);
        dfs(image, row-1, col, og, newColor);
        dfs(image, row, col-1, og, newColor);
        
    }
}