class Solution {
    List<String> answer;
    int longestWord;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> wordSet = new HashSet<>();
        longestWord = 0;
        for(String word: words){
            longestWord = Math.max(longestWord, word.length());
            wordSet.add(word);
        }
        answer = new ArrayList<>();
        // System.out.println("longest word " + longestWord);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // System.out.println("starting from " + board[i][j]);
                wordSearch2(board, wordSet, i, j, new StringBuilder());
            }
        }
        
        return answer;
    }

    private void wordSearch2(char[][] board, Set<String> wordSet, int x, int y, StringBuilder sb){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length || sb.length() > longestWord) {
            // System.out.println("returning because x is " + x + " and y is " + y);
            return;
        }
        // System.out.println("word is " + sb.toString());
        if(board[x][y] != '*'){
            sb.append(board[x][y]);
            char cur = board[x][y];
            board[x][y] = '*';
            String w = sb.toString();
            if(wordSet.contains(w)){
                // System.out.println("found word is " + w);
                answer.add(w);
                wordSet.remove(w);
            }   
            
                // System.out.println("backtracking " + sb.length());
                wordSearch2(board, wordSet, x+1, y, sb);
                wordSearch2(board, wordSet, x-1, y, sb);
                wordSearch2(board, wordSet, x, y+1, sb);
                wordSearch2(board, wordSet, x, y-1, sb);
            
            board[x][y] = cur;
            sb.setLength(sb.length()-1);
            return;
        }
        else {
            // System.out.println("met a *");
            return;
        }
    }
}