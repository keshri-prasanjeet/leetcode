class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        return bfs(maze, entrance, m, n);
    }

    private int bfs(char[][] maze, int[] entrance, int m, int n){
        Queue<int[]> dfsQ = new ArrayDeque<>();
        int[] initial = new int[]{entrance[0], entrance[1], 0};
        dfsQ.offer(initial);
        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };
        while(!dfsQ.isEmpty()){
            int[] top = dfsQ.poll();
            int x = top[0];
            int y = top[1];
            int steps = top[2];
            maze[x][y] = '+';
            if(x-1 < 0 || y-1 < 0 || x+1 == m || y+1 == n){
                if(x==entrance[0] && y==entrance[1]){
                    //do nothing
                }
                else{
                    return steps;
                }
            }

            for(int[] direction : directions){
                int newRow = x+direction[0];
                int newCol = y+direction[1];

                if(newRow >= 0 && newRow < m && newCol >=0 && newCol < n){
                    if(maze[newRow][newCol] == '.'){
                        maze[newRow][newCol] = '+';
                        int[] validCell = new int[]{newRow, newCol, steps+1};
                        dfsQ.offer(validCell); 
                    }
                }
            }
            
        }
        return -1;
    }
}