class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure cells (0) to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = { 
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions) {
                    int rd = r+dir[0];
                    int cd = c+dir[1];

                    if(rd<0 ||rd>=rows || cd<0 || cd>= cols || grid[rd][cd] != Integer.MAX_VALUE)
                        continue;

                    grid[rd][cd] = grid[r][c] +1;
                    queue.offer(new int[]{rd,cd});
                }
            }
        }
    }
}