class pair {
    int row;
    int col;

    pair(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<pair> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        // Add boundary land cells to the queue
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                q.offer(new pair(i, 0));
                vis[i][0] = 1;
            }

            if (grid[i][n - 1] == 1 && vis[i][n - 1] == 0) {
                q.offer(new pair(i, n - 1));
                vis[i][n - 1] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                q.offer(new pair(0, j));
                vis[0][j] = 1;
            }

            if (grid[m - 1][j] == 1 && vis[m - 1][j] == 0) {
                q.offer(new pair(m - 1, j));
                vis[m - 1][j] = 1;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS traversal
        while (!q.isEmpty()) {
            pair p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = p.row + dr[k];
                int nc = p.col + dc[k];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 1 &&
                    vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;
                    q.offer(new pair(nr, nc));
                }
            }
        }

        // Count land cells not visited by BFS
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}