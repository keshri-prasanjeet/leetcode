class Solution {
    List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] posiD = new boolean[(2*n)-1];
        boolean[] negiD = new boolean[(2*n)-1];
        char[][] chessBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = '.';
            }
        }
        placeNQueens(chessBoard, col, posiD, negiD, 0);
        return answer;
    }

    private void placeNQueens(char[][] chessBoard, boolean[] col, boolean[] posiD, boolean[] negiD, int row){
        if(row == chessBoard.length){
            List<String> oneBoard = new ArrayList<>();
            for(char[] r: chessBoard){
                oneBoard.add(new String(r));
            }
            answer.add(oneBoard);
            return;
        }
        int rowLength = chessBoard.length;
        for(int i=0;i<rowLength;i++){
            if(col[i]==false && posiD[row + i]==false && negiD[(row-i) + (rowLength-1)] == false){
                chessBoard[row][i] = 'Q';
                col[i]=true;
                posiD[row+i]=true;
                negiD[(row-i) + (rowLength-1)]=true;
                placeNQueens(chessBoard, col, posiD, negiD, row+1);
                chessBoard[row][i] = '.';
                col[i] = false;
                posiD[row+i] = false;
                negiD[(row-i) + (rowLength-1)] = false;
            }
        }
    }
}