class Solution {
    List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        int temp = n;
        String chessRow = "";
        while(temp-- > 0){
            chessRow+=".";
        }
        List<String> chessBoard = new ArrayList<>();
        temp = n;
        while(temp-- > 0){
            chessBoard.add(chessRow);
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posD = new HashSet<>();
        Set<Integer> negD = new HashSet<>();
        solve(chessBoard, 0, cols, posD, negD);

        return answer;
    }

    private void solve(List<String> chessBoard, int row, Set<Integer> cols, Set<Integer> posD, Set<Integer> negD){
        if(row == chessBoard.size()){
            answer.add(new ArrayList<>(chessBoard));
            return;
        }

        for(int i=0;i<chessBoard.size();i++){
            if(!cols.contains(i) && !posD.contains(i+row) && !negD.contains(i-row)){
                //if this cell is absolutely safe
                String currentRow = chessBoard.get(row);

                char[] currentRowArr = currentRow.toCharArray();
                currentRowArr[i] = 'Q';
                String updatedRow = new String(currentRowArr);

                chessBoard.set(row, updatedRow);
                cols.add(i);
                posD.add(i+row);
                negD.add(i-row);
                solve(chessBoard, row+1, cols, posD, negD);
                //now backtrack this

                chessBoard.set(row, currentRow);
                cols.remove(i);
                posD.remove(i+row);
                negD.remove(i-row);
            }
        }

    }
}