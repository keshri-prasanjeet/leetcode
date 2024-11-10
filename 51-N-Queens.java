class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiagonal = new HashSet<>();
        Set<Integer> negativeDiagonal = new HashSet<>();

        List<List<String>> allBoards = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String emptyRow = \\;
        for(int i=0;i<n;i++){
            emptyRow+='.';
        }

        for(int i=0;i<n;i++){
            board.add(emptyRow);
        }

        backtrack(cols, positiveDiagonal, negativeDiagonal, allBoards, board, 0);
        return allBoards;
    }

    private void backtrack(Set<Integer> cols, Set<Integer> positiveDiagonal, Set<Integer> negativeDiagonal, List<List<String>> allBoards, List<String> board, int row){
        if(row == board.size()){
            allBoards.add(new ArrayList<>(board));
            return;
        }

        for(int col=0;col<board.size();col++){
            if(!cols.contains(col) && !positiveDiagonal.contains(row + col) && !negativeDiagonal.contains(row-col)){

                cols.add(col);
                positiveDiagonal.add(row + col);
                negativeDiagonal.add(row - col);

                String newRow = placeOrRemoveQueen(board.get(row), col, true);
                board.set(row, newRow);

                backtrack(cols, positiveDiagonal, negativeDiagonal, allBoards, board, row+1);

                cols.remove(col);
                positiveDiagonal.remove(row + col);
                negativeDiagonal.remove(row - col);

                newRow = placeOrRemoveQueen(board.get(row), col, false);
                board.set(row, newRow);
            }
        }
        return;
    }

    private String placeOrRemoveQueen(String row, int col, boolean placeQueen){
        char toPlace = placeQueen ? 'Q' : '.';
        char[] rowArray = row.toCharArray();
        rowArray[col] = toPlace;
        return new String (rowArray);
    }
}