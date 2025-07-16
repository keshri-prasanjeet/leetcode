class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int totalOranges = 0;
        int rottenOranges = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] != 0){
                    totalOranges++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    rottenOranges++;
                }
            }
        }
        if(rottenOranges == totalOranges) return 0;
        if(rottenOranges == 0) return -1;
        // i have now total oranges and queue of rotten oranges

        int timeElapsed = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] top = q.poll();
                for(int[] direction: new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}}){
                    int x = top[0] + direction[0];
                    int y = top[1] + direction[1];
                    if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length){
                        if(grid[x][y] == 1){
                            //found a fresh orange next a rotten orange
                            grid[x][y] = 2;
                            q.offer(new int[]{x,y});
                            rottenOranges++;
                        }
                    }
                }
            }
            timeElapsed++;
            if(rottenOranges == totalOranges) return timeElapsed;
        }
        return -1;
    }
}