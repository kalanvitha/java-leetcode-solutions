class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int stepcount = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(entrance);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';
        while (!dq.isEmpty()) {
            int size = dq.size();
            stepcount++;
            for (int j = 0; j < size; j++) {
                int[] temp = dq.poll();
                int x = temp[0];
                int y = temp[1];
            for (int i = 0; i < 4; i++) {
                    int r = x + dr[i];
                    int c = y + dc[i];

                    // Check boundaries
                    if (r < 0 || r >= maze.length ||
                        c < 0 || c >= maze[0].length) {
                        continue;
                    }

                    // Only move to empty cells
                    if (maze[r][c] == '.') {

                        // If it is a border cell, it is the nearest exit
                        if (r == 0 || r == maze.length - 1 ||
                            c == 0 || c == maze[0].length - 1) {
                            return stepcount;
                        }

                        // Mark visited
                        maze[r][c] = '+';

                        dq.offer(new int[]{r, c});
                    }
                }
            }
        }

        return -1;
    }
}