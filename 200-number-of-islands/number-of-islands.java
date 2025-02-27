class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    DFSIslandSubmerge(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void DFSIslandSubmerge(char[][] grid, int m, int n){
        if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == '0') return;
        grid[m][n] = '0';
        DFSIslandSubmerge(grid, m+1, n);
        DFSIslandSubmerge(grid, m-1, n);
        DFSIslandSubmerge(grid, m, n+1);
        DFSIslandSubmerge(grid, m, n-1);
    }
}