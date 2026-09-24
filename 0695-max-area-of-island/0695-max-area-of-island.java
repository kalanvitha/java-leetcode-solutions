class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {

        int n = grid.length;
        int m = grid[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;

        area += dfs(grid, r - 1, c); // Up
        area += dfs(grid, r + 1, c); // Down
        area += dfs(grid, r, c - 1); // Left
        area += dfs(grid, r, c + 1); // Right

        return area;
    }
}