class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        //visited array must be tracked
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == wordArr[0]){
                    if(findWord(i, j, board, wordArr, 0) == true) return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, char[][] board, char[] wordArr, int idx){
        if(idx == wordArr.length) return true;
        if(i<0 || i == board.length || j<0 || j == board[0].length || board[i][j] != wordArr[idx]) return false;

        char temp = board[i][j];
        board[i][j] = '$';

        boolean ans =  
            findWord(i-1,j,board,wordArr,idx+1) || 
            findWord(i+1,j,board,wordArr,idx+1) || 
            findWord(i,j+1,board,wordArr,idx+1) ||
            findWord(i,j-1,board,wordArr,idx+1); 

        board[i][j] = temp;
        return ans;
    }
}