class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudokuCheck = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int sudoChar = board[i][j];
                if(sudoChar == '.') continue;
                int boxNum = (i/3) * 3 + (j/3);
                if(!sudokuCheck.add(sudoChar + "r" + i)) return false;
                if(!sudokuCheck.add(sudoChar + "c" + j)) return false;
                if(!sudokuCheck.add(sudoChar + "b" + boxNum)) return false;
            }
        }
        return true;
    }
}