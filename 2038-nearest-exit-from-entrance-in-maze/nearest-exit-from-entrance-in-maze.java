class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{entrance[0], entrance[1], 0});
        int[][] directions = {
            {1,0},
            {0,1},
            {0,-1},
            {-1,0}
        };

        while(!bfsQ.isEmpty()){
            int[] top = bfsQ.poll();
            int x = top[0];
            int y = top[1];
            int steps = top[2];
            if(x==0 || y==0 || x+1==m || y+1==n){
                if(x == entrance[0] && y == entrance[1]){}
                else return steps;
            }
            for(int[] direction: directions){
                int row = top[0]+direction[0];
                int col = top[1]+direction[1];
                if(row>=0 && row<m && col>=0 && col<n){
                    //cell is not out of bounds
                    if(maze[row][col] == '.'){
                        maze[row][col] = '+';
                        bfsQ.offer(new int[]{row, col, steps+1});
                    }
                }
            }
        }
        return -1;
    }
}