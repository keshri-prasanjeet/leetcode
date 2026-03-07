class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    List<String> answer = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                wordSearch(board, root, i, j);
            }
        }
        
        return answer;
    }

    private void wordSearch(char[][] board, TrieNode node, int x, int y){
        if(x < 0 || y < 0 || x == board.length || y == board[0].length) return;

        char cur = board[x][y];

        if(cur == '*' || node.children[cur - 'a'] == null) return;

        node = node.children[cur - 'a'];
        if(node.word != null){
            answer.add(node.word);
            node.word = null;
        }

        //go all four directions

        board[x][y] = '*';

        wordSearch(board, node, x-1, y);
        wordSearch(board, node, x+1, y);
        wordSearch(board, node, x, y-1);
        wordSearch(board, node, x, y+1);

        board[x][y] = cur;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(char a : word.toCharArray()){
                if(node.children[a-'a'] == null){
                    TrieNode newNode = new TrieNode();
                    node.children[a-'a'] = newNode;
                }
                node = node.children[a-'a'];
            }
            node.word = word;
        }

        return root;
    }
}