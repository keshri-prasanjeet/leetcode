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
        boolean[] cols = new boolean[n];
        boolean[] posD = new boolean[(2*n)-1];
        boolean[] negD = new boolean[(2*n)-1];



        // Set<Integer> cols = new HashSet<>();
        // Set<Integer> posD = new HashSet<>();
        // Set<Integer> negD = new HashSet<>();
        solveNQueens(nBoard, n, 0, cols, posD, negD);
        return allBoards;
    }

    private void solveNQueens(char[][] nBoard, int n, int row, boolean[] cols, boolean[] posD, boolean[] negD){
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
            if(cols[i] == false && posD[i+row] == false && negD[i-row + (n-1)] == false){
                //this cell is safe from other queens

                nBoard[row][i] = 'Q';
                cols[i] = true;
                posD[i+row] = true;
                negD[i-row + (n-1)] = true;

                solveNQueens(nBoard, n, row+1, cols, posD, negD);

                nBoard[row][i] = '.';
                cols[i] = false;
                posD[i+row] = false;
                negD[i-row + (n-1)] = false;
            }
        }
    }
}