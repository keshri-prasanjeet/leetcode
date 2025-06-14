class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        List<String> currBoard = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posD = new HashSet<>();
        Set<Integer> negD = new HashSet<>();

        String rowString = "";
        for(int i=0;i<n;i++){
            rowString+=".";
        }
        for(int i=0;i<n;i++){
            currBoard.add(rowString);
        }

        solveNQueens(allBoards, currBoard, cols, posD, negD, 0);
        return allBoards;
    }

    private void solveNQueens(List<List<String>> allBoards, List<String> currBoard, Set<Integer>cols, Set<Integer>posD, Set<Integer>negD, int row){
        if(row == currBoard.size()){
            allBoards.add(new ArrayList<>(currBoard));
            return;
        }

        for(int i = 0; i<currBoard.size(); i++){
            if(!cols.contains(i) && !posD.contains(i+row) && !negD.contains(i-row)){
                //we can put a new queen here
                String curRow = currBoard.get(row);
                String rowWithQueen = placeQueen(curRow, i);//placing a queen
                currBoard.set(row, rowWithQueen);

                cols.add(i);
                posD.add(i+row);
                negD.add(i-row);

                solveNQueens(allBoards, currBoard, cols, posD, negD, row+1);

                //now we have fired the recursive call we need to backtrack/make choice to not put in this col

                cols.remove(i);
                posD.remove(i+row);
                negD.remove(i-row);

                currBoard.set(row, curRow);

                //now that we have chose to not put a queen in this col, next iteration of this loop, next col will have chance
            }
        }
    }

    private String placeQueen(String rowString, int pos){
        char[] rowArr = rowString.toCharArray();
        rowArr[pos] = 'Q';
        return new String(rowArr);
    }
}