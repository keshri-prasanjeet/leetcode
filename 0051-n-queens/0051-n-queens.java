class Solution {
    List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = '.';
            }
        }

        answer = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] posD =new boolean[(2*n)-1];
        boolean[] negD =new boolean[(2*n)-1];

        placeNQueens(chessBoard, 0, col, posD, negD);
        
        return answer;
    }

    private void placeNQueens(char[][] chessBoard, int row, boolean[] col, boolean[] posD, boolean[] negD){
        if(row == chessBoard.length){
            List<String> board = new ArrayList<>();
            for(char[] r: chessBoard){
                board.add(new String(r));
            }
            answer.add(board);
            return;
        }
        int n = chessBoard.length;
        for(int i=0;i<n;i++){
            if(col[i] == false && posD[row+i] == false && negD[row-i + (n-1)] == false){
                chessBoard[row][i] = 'Q';
                col[i] = true;
                posD[row+i] = true;
                negD[row-i + (n-1)] = true;
                placeNQueens(chessBoard, row + 1, col, posD, negD);
                chessBoard[row][i] = '.';
                col[i] = false;
                posD[row+i] = false;
                negD[row-i + (n-1)] = false;
            }           
        }    
    }
}