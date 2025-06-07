class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> rotten = new ArrayDeque<>();
        int freshO = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) freshO++;
                else if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                }
            }
        }
        //i have a track of the rotten oranges and i also know the count of the fresh ones

        if(freshO==0) return 0;


        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };
        int minutes = 0;
        while(!rotten.isEmpty()){
            int rottenO = rotten.size();
            while(rottenO-- > 0){
                int[] top = rotten.poll();
                int x = top[0];
                int y = top[1];

                for(int[] direction: directions){
                    int newRow = x+direction[0];
                    int newCol = y+direction[1];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                        //we are at a safe grid
                        if(grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;//make it rotten
                            freshO--;
                            rotten.offer(new int[]{newRow, newCol});//add it to the queue
                        }
                    }
                }
            }
            minutes++;
            if(freshO == 0) return minutes;
        }
        return -1;
    }
}