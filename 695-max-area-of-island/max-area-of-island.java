class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    Queue<Pair> q;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i,j));
                    grid[i][j] = 0;
                    area++;
                    findMaxIsland(grid);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    private void findMaxIsland(int[][] grid){
        
        while(!q.isEmpty()){
            Pair top = q.poll();
            int x = top.a;
            int y = top.b;
            for(int[] direction: directions){
                int a = x + direction[0];
                int b = y + direction[1];
                if(a >=0 && a < grid.length && b >= 0 && b < grid[0].length){
                    if(grid[a][b] == 1){
                        area++;
                        q.offer(new Pair(a,b));
                        grid[a][b] = 0;
                    }
                }
            }
        }
    }
}

class Pair{
    int a;
    int b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}