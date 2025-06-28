class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(char[] row: board){
            Set<Character> rowCheck = new HashSet<>();
            for(char a: row){
                if(a=='.') continue;
                if(rowCheck.contains(a)) {
                    return false;
                }
                rowCheck.add(a);
            }
        }
        
        for(int i=0;i<9;i++){
            Set<Character> colCheck = new HashSet<>();
            for(int j=0;j<9;j++){
                char a = board[j][i];
                if(a=='.') continue;
                if(colCheck.contains(a)) {
                    return false;
                }
                colCheck.add(a);
            }
        }

        for(int i=0;i<=6;i+=3){
            for(int j=0;j<=6;j+=3){
                Set<Character> block = new HashSet<>();
                // System.out.println("i = " + i + " j = " + j);
                for(int startI = i;startI<i+3;startI++){
                    for(int startJ = j;startJ<j+3;startJ++){
                        // System.out.println("startI = " + startI + " startJ = " + startJ);
                        char a = board[startI][startJ];
                        if(a == '.') continue;
                        if(block.contains(a)) {
                            // System.out.println(startI + " " + startJ + " " + a);
                            return false;
                        }
                        block.add(a);
                    }
                }
            }
        }

        return true;
        
    }
}