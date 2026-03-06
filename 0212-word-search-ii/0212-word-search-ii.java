class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        for(int i = 0;i < board.length; i++){
            for(int j = 0;j < board[0].length;j++){
                findWord2(board, i, j, root);
            }
        }
        return result;
    }

    private void findWord2(char[][] board, int x, int y, TrieNode node){
        if(x < 0 || x == board.length || y < 0 || y == board[0].length) return;

        char c = board[x][y];

        if(c == '*' || node.children[c-'a'] == null) return;

        node = node.children[c - 'a'];

        if(node.word != null){
            result.add(node.word);
            node.word = null;//avoid duplicates
        }

        board[x][y] = '*';

        findWord2(board, x + 1, y, node);
        findWord2(board, x - 1, y, node);
        findWord2(board, x, y + 1, node);
        findWord2(board, x, y - 1, node);

        board[x][y] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word: words){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }
            node.word = word;
        }

        return root;
    }
}