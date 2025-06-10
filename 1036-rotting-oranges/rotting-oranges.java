class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> rottenQ = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) freshOranges++;
                if(grid[i][j]==2){
                    rottenQ.offer(new int[]{i,j});
                }
            }
        }if(freshOranges == 0) return 0;
        //counted all the fresh oranges & rotten to compare with later
        int minutesElapsed = 0;
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!rottenQ.isEmpty()){
            int currentRotten = rottenQ.size();
            for(int i=0;i<currentRotten;i++){
                int[] rottenOrange = rottenQ.poll();
                for(int[] direction:directions){
                    int row = direction[0]+rottenOrange[0];
                    int col = direction[1]+rottenOrange[1];
                    if(row >=0 && row<m && col >=0 && col<n){
                        //cell within bounds
                        if(grid[row][col] == 1){
                            grid[row][col] = 2;
                            rottenQ.offer(new int[]{row,col});
                            freshOranges--;
                        }
                    }
                }
            }
            minutesElapsed++;
            if(freshOranges == 0) return minutesElapsed;
        }
        return -1;
    }
}