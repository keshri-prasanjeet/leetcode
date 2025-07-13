class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };

    Queue<Pair> q;
    public int numIslands(char[][] grid) {
        q = new LinkedList<>();
        int totalIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    totalIslands++;
                    q.offer(new Pair(i,j));
                    grid[i][j] = '*';
                    calculateIslands(grid);
                }
            }
        }
        return totalIslands;
    }

    private void calculateIslands(char[][] grid){        
        while(!q.isEmpty()){
            Pair top = q.poll();
            int a = top.x;
            int b = top.y;
            for(int[] direction: directions){
                int x = direction[0] + a;
                int y = direction[1] + b;
                
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                    //valid index
                    if(grid[x][y] == '1'){
                        q.offer(new Pair(x,y));//add the neighbour to the queue
                        grid[x][y] = '*'; //make the current one visited
                    }
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}