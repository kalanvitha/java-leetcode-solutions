class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add boundary O's to the queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][n - 1] == 'O') {
                q.offer(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[m - 1][j] == 'O') {
                q.offer(new int[]{m - 1, j});
                board[m - 1][j] = '#';
            }
        }

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Capture surrounded regions and restore safe regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}