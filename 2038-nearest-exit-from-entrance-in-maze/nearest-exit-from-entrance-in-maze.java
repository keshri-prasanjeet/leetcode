class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{entrance[0],entrance[1],0});

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        while(!bfsQ.isEmpty()){
            int[] top = bfsQ.poll();
            int x = top[0];
            int y = top[1];
            int steps=top[2];

            maze[x][y] = '+';//deque change
            if(x-1<0 || y-1 <0 || x+1==m || y+1==n){
                if(x==entrance[0] && y==entrance[1]){
                //do nothing
                }
                else{
                    return steps;//first place where it is edge is the closesnt point
                }
            }

            for(int[] direction: directions){
                int row = x+direction[0];
                int col = y+direction[1];
                if(row >=0 && col >=0 && row < m && col < n){
                    //safe cell
                    if(maze[row][col]=='.'){
                        maze[row][col] = '+';//enque change
                        bfsQ.offer(new int[]{row, col, steps+1});//steps tracking
                    }
                }
            }
        }
        return -1;
    }
}