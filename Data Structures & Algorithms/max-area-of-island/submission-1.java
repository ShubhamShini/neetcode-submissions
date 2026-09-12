class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count =0;
        int ans = 0;
        for(int i =0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    count = dfs(i,j,grid);
                    ans = Math.max(ans,count);
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] grid) {
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int a = dfs(i-1,j,grid);
        int b = dfs(i+1,j,grid);
        int c = dfs(i,j-1,grid);
        int d = dfs(i,j+1,grid);

        return a+b+c+d+1;
    }
}
