class Solution {

    int[][] directions = {
        {1,0},
        {0,1},
        {-1, 0},
        {0, -1}
    };
    boolean[][] visited;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        //keep a visited map to remember which cell you visited
        // make a direction list to direct in four directions
        // if recursion keeps going and even wordIndex at last is okay that means word found

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)== board[i][j]){
                    if(findWord(board, i, j, word, 0)){
                        return true;
                    }
                } 
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, String word, int wordIndex){
        if(word.charAt(wordIndex)!=board[i][j]) return false;
        if(wordIndex + 1 == word.length()) return true; // head first check
        visited[i][j] = true;
        for(int[] direction: directions){
            int x = direction[0] + i;
            int y = direction[1] + j;

            if(x < m && x >= 0 && y < n && y >=0 && visited[x][y] == false){
                if(wordIndex + 1 <= word.length()){
                    if(findWord(board, x, y, word, wordIndex+1)) return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}