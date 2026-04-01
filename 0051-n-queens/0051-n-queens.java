class Solution {
    boolean[] column;
    boolean[] posDia;
    boolean[] negDia;
    List<List<String>> nQueens;
    public List<List<String>> solveNQueens(int n) {
        //there have to be three hash sets
        // one to check if there are two queens in one column
        // one to check if there are two queens in one pos Diagonal
        // one to check if there are two queens in one neg Diagonal

        // loop throuhg the chess board and find 
        column = new boolean[n];
        posDia = new boolean[n+n];
        negDia = new boolean[n+n];
        nQueens = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = '.';
            }
        }
        placeNQueens(n, 0, chessBoard);
        return nQueens;
    }

    private void placeNQueens(int n, int row, char[][] chessBoard){
        if(row == n){
            List<String> answer = new ArrayList<>();
            for(char[] boardRow:chessBoard){
                answer.add(new String(boardRow));
            }
            nQueens.add(answer);
            return;
        }

        for(int i=0;i<n;i++){
            if(column[i] == false && posDia[i+row] == false && negDia[i-row + (n-1)] == false){
                chessBoard[row][i] = 'Q';
                column[i] = true;
                posDia[i+row] = true;
                negDia[i-row + (n-1)] = true;
                placeNQueens(n, row+1, chessBoard);
                chessBoard[row][i] = '.';
                column[i] = false;
                posDia[i+row] = false;
                negDia[i-row + (n-1)] = false;
            }
        }
    }

}