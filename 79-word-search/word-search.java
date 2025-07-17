class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        //need to maintain a visited map so that i dont go back on the same path again and again
        //go in four directinos
        //early check so that my check condition is not only on out of bounds

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(findWord(i, j, word, board, 0) == true) return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, String word, char[][] board, int index){
        if(word.charAt(index)!=board[i][j]) return false;
        if(index + 1 == word.length()) return true; // means i am at the last point and this also matches
        visited[i][j] = true;

        for(int[] direction : new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}}){
            int x = direction[0]+i;
            int y = direction[1]+j;
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && visited[x][y] == false){
                if(index + 1 < word.length()){
                    if(findWord(x, y, word, board, index+1) == true) return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}