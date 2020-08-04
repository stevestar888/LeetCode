class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0)
            return 0;
        
        int level = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size() ;
            level++;
            while (size-- > 0) {
                int[] cur = q.poll();
                
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                        continue;
                    }
                    
                    if (grid[r][c] == 0 || grid[r][c] == 2) {
                        continue;
                    }
                    
                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[] {r, c});
                }
            }
        }
        
        return fresh == 0 ? level-1 : -1;
    }
}