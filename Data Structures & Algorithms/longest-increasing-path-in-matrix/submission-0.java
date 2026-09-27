class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[row][cols];
        int result =0;

        for(int i=0;i<row;i++) {
            for(int j=0;j<cols;j++) {
                result = Math.max(result, dfs(i,j,dp,matrix));
            }
        }
        return result;
    }

    int dfs(int i, int j, int[][] dp, int[][] matrix) {
        if(dp[i][j] !=0) return dp[i][j];

        int length =1;

        int row = matrix.length;
        int cols = matrix[0].length;

        if(i<row-1 && matrix[i+1][j] > matrix[i][j])
            length = Math.max(length, dfs(i+1,j,dp,matrix)+1);

        if(i>0 && matrix[i-1][j] > matrix[i][j])
            length = Math.max(length, dfs(i-1,j,dp,matrix)+1);

        if(j<cols-1 && matrix[i][j+1] >matrix[i][j])
            length = Math.max(length, dfs(i,j+1,dp,matrix)+1);

        if(j>0 && matrix[i][j-1] > matrix[i][j]) 
            length = Math.max(length, dfs(i,j-1,dp,matrix)+1);
        dp[i][j] = length;
        return length;
    }
}
