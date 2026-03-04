class Solution {
    List<List<String>> solution;
    public List<List<String>> solveNQueens(int n) {
        //no two queens can share
        //same row
        //same col
        //same rightDiagonal
        //same leftDiagonal
        boolean[] col = new boolean[n];
        boolean[] rDia = new boolean[2*n];
        boolean[] lDia = new boolean[2*n];
        char[][] chessBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = '.';
            }
        }
        solution = new ArrayList<>();
        placeNQueens(chessBoard, col, rDia, lDia, 0);
        return solution;
    }

    private void placeNQueens(char[][] chessBoard, boolean[] col, boolean[] rDia, boolean[] lDia, int row){
        if(row == chessBoard.length){
            List<String> completeBoard = new ArrayList<>();
            for(char[] solutionRow:chessBoard){
                completeBoard.add(new String(solutionRow));
            }
            solution.add(completeBoard);
            return;
        }
        int n = chessBoard.length;
        for(int i=0;i<chessBoard.length;i++){
            if(col[i] == false && rDia[i+row] == false && lDia[(i-row) + (n-1)] == false){
                chessBoard[row][i] = 'Q';
                col[i] = true;
                rDia[i+row] = true;
                lDia[(i-row) + (n-1)] = true;
                placeNQueens(chessBoard, col, rDia, lDia, row+1);
                chessBoard[row][i] = '.';
                col[i] = false;
                rDia[i+row] = false;
                lDia[(i-row) + (n-1)] = false;
            }
        }
    }
}