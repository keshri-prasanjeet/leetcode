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
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                wordSearch2(board, wordSet, i, j, new StringBuilder());
            }
        }
        
        return answer;
    }

    private void wordSearch2(char[][] board, Set<String> wordSet, int x, int y, StringBuilder sb){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length || sb.length() > longestWord) return;
        if(board[x][y] != '*'){
            sb.append(board[x][y]);
            char cur = board[x][y];
            board[x][y] = '*';
            String w = sb.toString();
            if(wordSet.contains(w)){
                answer.add(w);
                wordSet.remove(w);
            }   
            
            wordSearch2(board, wordSet, x+1, y, sb);
            wordSearch2(board, wordSet, x-1, y, sb);
            wordSearch2(board, wordSet, x, y+1, sb);
            wordSearch2(board, wordSet, x, y-1, sb);
            
            board[x][y] = cur;
            sb.setLength(sb.length()-1);
            return;
        }
    }
}