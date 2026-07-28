class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific
        for (int c = 0; c < cols; c++)
            dfs(0, c, pacific, heights);

        for (int r = 0; r < rows; r++)
            dfs(r, 0, pacific, heights);

        // Atlantic
        for (int c = 0; c < cols; c++)
            dfs(rows - 1, c, atlantic, heights);

        for (int r = 0; r < rows; r++)
            dfs(r, cols - 1, atlantic, heights);

        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {

        if (visited[r][c]) return;

        visited[r][c] = true;

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length)
                continue;

            // Reverse flow: only move to equal or higher cells
            if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}