class Solution {
    List<List<String>> allBoards;
    public List<List<String>> solveNQueens(int n) {
        allBoards = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        List<String> board = new ArrayList<>();
        String row = sb.toString();
        for(int i=0;i<n;i++){
            board.add(row);
        }

        char[][] nBoard = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nBoard[i][j] = '.';
            }
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posD = new HashSet<>();
        Set<Integer> negD = new HashSet<>();
        solveNQueens(board, nBoard, n, 0, cols, posD, negD);
        return allBoards;
    }

    private void solveNQueens(List<String> board, char[][] nBoard, int n, int row, Set<Integer> cols, Set<Integer> posD, Set<Integer> negD){
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
                String currentRow = board.get(row);
                char[] currentRowArr = currentRow.toCharArray();
                currentRowArr[i] = 'Q';

                nBoard[row][i] = 'Q';
                board.set(row, new String(currentRowArr));
                cols.add(i);
                posD.add(i+row);
                negD.add(i-row);
                solveNQueens(board, nBoard, n, row+1, cols, posD, negD);

                nBoard[row][i] = '.';
                board.set(row, currentRow);
                cols.remove(i);
                posD.remove(i+row);
                negD.remove(i-row);
            }
        }
    }
}