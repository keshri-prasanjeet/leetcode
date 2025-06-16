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
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posD = new HashSet<>();
        Set<Integer> negD = new HashSet<>();
        solveNQueens(board, n, 0, cols, posD, negD);
        return allBoards;
    }

    private void solveNQueens(List<String> board, int n, int row, Set<Integer> cols, Set<Integer> posD, Set<Integer> negD){
        if(row == n){
            //we have placed all the queens
            allBoards.add(new ArrayList<>(board));
            return;
        }

        for(int i=0;i<n;i++){
            if(!cols.contains(i) && !posD.contains(i+row) && !negD.contains(i-row)){
                //this cell is safe from other queens
                String currentRow = board.get(row);
                char[] currentRowArr = currentRow.toCharArray();
                currentRowArr[i] = 'Q';
                board.set(row, new String(currentRowArr));
                cols.add(i);
                posD.add(i+row);
                negD.add(i-row);
                solveNQueens(board, n, row+1, cols, posD, negD);
                board.set(row, currentRow);
                cols.remove(i);
                posD.remove(i+row);
                negD.remove(i-row);
            }
        }
    }
}