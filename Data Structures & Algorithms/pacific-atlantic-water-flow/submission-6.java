class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for(int i=0;i<r;i++) 
            dfs(i,0,pacific,heights);
        
        for(int i=0;i<c;i++)
            dfs(0,i,pacific,heights);

        for(int i=0;i<r;i++) 
            dfs(i,c-1,atlantic,heights);
        
        for(int i=0;i<c;i++)
            dfs(r-1,i,atlantic,heights);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<r;i++) {
            for(int j =0;j<c;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    void dfs(int r,int c, boolean[][] visited, int[][] heights) {
        if(visited[r][c]) return;

        visited[r][c] = true;

        for(int[] dir:dirs) {
            int rd = r+dir[0];
            int cd = c+dir[1];

            if(rd<0 || cd<0 || rd>=heights.length || cd>= heights[0].length) continue;

            if(heights[rd][cd] >= heights[r][c]) 
                dfs(rd,cd,visited,heights);
        }
    }
}
