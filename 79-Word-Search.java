class Solution {

    boolean answer;
    public boolean exist(char[][] board, String word) {
        this.answer = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    findWord(board, word, 0, 0, i, j);
                    if(answer == true) return answer;
                }
            }
        }

        return false;
    }

    private void findWord(char[][] board, String word, int index, int count, int x, int y){
        if(x < 0 || y < 0 || x == board.length || y == board[0].length || answer) return;

        if(board[x][y] != word.charAt(index)) return;

        count++;

        if(count == word.length()){
            answer = true;
            return;
        }

        char temp = board[x][y];
        board[x][y] = '$';

        findWord(board, word, index+1, count, x+1, y);
        findWord(board, word, index+1, count, x-1, y);
        findWord(board, word, index+1, count, x, y+1);
        findWord(board, word, index+1, count, x, y-1);


        count--;
        board[x][y] = temp;

    }
}