class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m+1][n+1]; // extra row and col for easier 0-index handling

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i+1][j+1] = matrix[i][j]
                                 + prefix[i][j+1]
                                 + prefix[i+1][j]
                                 - prefix[i][j];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return prefix[r2+1][c2+1]
             - prefix[r1][c2+1]
             - prefix[r2+1][c1]
             + prefix[r1][c1];
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */