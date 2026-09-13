class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh =0;

        for(int i =0;i<rows;i++) {
            for(int j =0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh ==0) {
            return 0;
        }

        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];
                if(fresh ==0) {
                    return count;
                }

                for(int[] dir: directions){
                    int rd = r+dir[0];
                    int cd = c+dir[1];

                    if(rd<0 || cd<0 || rd>=rows || cd>=cols || grid[rd][cd] == 0)
                        continue;
                    if(grid[rd][cd] ==1) {
                        fresh--;
                        grid[rd][cd] =2;
                        queue.offer(new int[]{rd,cd});
                    }
                    if(fresh ==0) {
                        return count+1;
                    }
                }
            }
            count++;
        }

        return fresh==0? count:-1;
    }
}
