class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        boolean[][] corner = new boolean[r][c];
        for(int i =0;i<r;i++) {
            if(board[i][0] == 'O') dfs(i,0,corner,board);
            if(board[r-i-1][c-1] == 'O') dfs(r-i-1,c-1,corner,board);
        }
        for(int i =0;i<c;i++) {
            if(board[0][i] == 'O') dfs(0,i,corner,board);
            if(board[r-1][c-i-1] == 'O') dfs(r-1,c-i-1,corner,board);
        }

        for(int i=0;i<r;i++) {
            for(int j =0;j<c;j++) {
                if(!corner[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    void dfs(int r, int c, boolean[][] corner, char[][] board) {
        corner[r][c] = true;
        for(int[] d:dirs) {
            int rd = r+ d[0];
            int cd = c+ d[1];

            if(rd<0 || cd<0 || rd>= board.length || cd>= board[0].length) continue;
            if(board[rd][cd] == 'O' && !corner[rd][cd]) {
                dfs(rd,cd,corner,board);
            }

        }
    }
}
