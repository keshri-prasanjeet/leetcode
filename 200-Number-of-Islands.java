class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    DFSzeroMarking(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void DFSzeroMarking(char[][] grid, int m, int n){
        if(m<0 || m>=grid.length || n<0 || n>=grid[0].length || grid[m][n]=='0') return;
        grid[m][n] = '0';
        DFSzeroMarking(grid, m-1, n);
        DFSzeroMarking(grid, m+1, n);
        DFSzeroMarking(grid, m, n+1);
        DFSzeroMarking(grid, m, n-1);
    }
}