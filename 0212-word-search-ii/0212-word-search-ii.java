class Solution {
    List<String> answer = new ArrayList<>();

    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = buildTrie(words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.children[board[i][j] - 'a'] != null){
                    wordSearch(board, root, i, j);
                }
            }
        }

        return answer;
    }

    private void wordSearch(char[][] board, TrieNode root, int x, int y){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length || board[x][y] == '$') return;

        if(root.children[board[x][y] - 'a'] == null) return;

        root = root.children[board[x][y] - 'a'];

        if(root.word != null){
            answer.add(root.word);
            root.word = null;
        }

        char cur = board[x][y];
        board[x][y] = '$';

        wordSearch(board, root, x - 1, y);
        wordSearch(board, root, x + 1, y);
        wordSearch(board, root, x, y - 1);
        wordSearch(board, root, x, y + 1);

        board[x][y] = cur;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char a: word.toCharArray()){
                if(node.children[a - 'a'] == null){
                    node.children[a-'a'] = new TrieNode();
                }
                node = node.children[a-'a'];
            }
            node.word = word;
        }

        return root;
    }
}