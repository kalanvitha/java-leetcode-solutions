class Solution {

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {

        int n = image.length;
        int m = image[0].length;

        // Boundary check
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return;
        }

        // Only fill pixels having the original color
        if (image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = newColor;

        // Up
        dfs(image, r - 1, c, originalColor, newColor);

        // Down
        dfs(image, r + 1, c, originalColor, newColor);

        // Left
        dfs(image, r, c - 1, originalColor, newColor);

        // Right
        dfs(image, r, c + 1, originalColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Already the same color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }
}