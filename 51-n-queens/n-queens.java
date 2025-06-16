class Solution {
    List<List<String>> allBoards;
    public List<List<String>> solveNQueens(int n) {
        allBoards = new ArrayList<>();

        char[][] nBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nBoard[i][j] = '.';
            }
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posD = new HashSet<>();
        Set<Integer> negD = new HashSet<>();
        solveNQueens(nBoard, n, 0, cols, posD, negD);
        return allBoards;
    }

    private void solveNQueens(char[][] nBoard, int n, int row, Set<Integer> cols, Set<Integer> posD, Set<Integer> negD){
        if(row == n){
            //we have placed all the queens

            List<String> result = new ArrayList<>();

            for(char[] cRow: nBoard){
                result.add(new String(cRow));
            }
            allBoards.add(result);
            return;
        }

        for(int i=0;i<n;i++){
            if(!cols.contains(i) && !posD.contains(i+row) && !negD.contains(i-row)){
                //this cell is safe from other queens

                nBoard[row][i] = 'Q';
                cols.add(i);
                posD.add(i+row);
                negD.add(i-row);

                solveNQueens(nBoard, n, row+1, cols, posD, negD);

                nBoard[row][i] = '.';
                cols.remove(i);
                posD.remove(i+row);
                negD.remove(i-row);
            }
        }
    }
}