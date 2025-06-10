class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{entrance[0], entrance[1], 0});

        int[][] directions = {
            {0,1},{1,0},{-1,0},{0,-1}
        };

        while(!bfsQ.isEmpty()){
            int top[] = bfsQ.poll();
            int x = top[0];
            int y = top[1];
            int steps = top[2];

            //check if the current cell is a edge cell
            if(x==0 || y==0 || x+1==m || y+1==n){
                if(x==entrance[0] && y==entrance[1]){}
                else return steps;
            }

            //not a edge cell

            for(int[] direction: directions){
                int row = direction[0]+x;
                int col = direction[1]+y;

                if(row >= 0 && col >=0 && row < m && col < n){
                    //this cell is not out of bounds
                    if(maze[row][col] == '.'){
                        maze[row][col] = '+'; //make this a wall to not go in infinite loop
                        bfsQ.offer(new int[]{row, col, steps+1});
                    }
                }
            }
        }
        return -1;
    }
}