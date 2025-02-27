class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<n;i++){
            makeEdgeImmune(board, 0, i);
            makeEdgeImmune(board, m-1, i);
        }

        for(int i=0;i<m;i++){
            makeEdgeImmune(board, i,0);
            makeEdgeImmune(board, i, n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'ø') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void makeEdgeImmune(char[][] board, int x, int y){
        if(x<0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;
        board[x][y] = 'ø';
        makeEdgeImmune(board, x-1, y);
        makeEdgeImmune(board, x+1, y);
        makeEdgeImmune(board, x, y-1);
        makeEdgeImmune(board, x, y+1);
    }
}