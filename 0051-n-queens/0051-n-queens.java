class Solution {
    List<List<String>> solution;

    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] pDia = new boolean[2 * n];
        boolean[] nDia = new boolean[2 * n];
        solution = new ArrayList<>();

        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }

        dfsPlaceQueens(col, pDia, nDia, chessboard, 0);
        return solution;
    }

    private void dfsPlaceQueens(boolean[] col, boolean[] pDia, boolean[] nDia, char[][] chessboard, int row) {
        if (row == chessboard.length) {
            //gether the answer and put it in the solution list
            List<String> solutionString = new ArrayList<>();
            for (char[] solutionRow : chessboard) {
                solutionString.add(new String(solutionRow));
            }
            solution.add(solutionString);
            return;
        }
        int n = chessboard.length;
        for (int i = 0; i < n; i++) {
            if (col[i] == false && pDia[i + row] == false && nDia[(i - row) + (n - 1)] == false) {
                chessboard[row][i] = 'Q';
                col[i] = true;
                pDia[i + row] = true;
                nDia[(i - row) + (n - 1)] = true;
                dfsPlaceQueens(col, pDia, nDia, chessboard, row + 1);
                chessboard[row][i] = '.';
                col[i] = false;
                pDia[i + row] = false;
                nDia[(i - row) + (n - 1)] = false;
            }
        }
    }
}