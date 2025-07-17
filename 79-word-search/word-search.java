class Solution {
    public boolean exist(char[][] board, String word) {
        //backtracking way

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    if(findWord(i, j, word, board, 0) == true) return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, String word, char[][] board, int index){
        if(index == word.length()) return true;

        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(index)) return false;

        char curr = board[i][j];

        board[i][j] = '$';

        boolean ans = findWord(i+1, j, word, board, index+1) || 
                findWord(i-1, j, word, board, index+1) || 
                findWord(i, j+1, word, board, index+1) || 
                findWord(i, j-1, word, board, index+1);
        board[i][j] = curr;
        return ans;
    }
}