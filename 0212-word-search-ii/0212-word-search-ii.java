class Solution {
    TrieNode root;
    List<String> allWords;
    public List<String> findWords(char[][] board, String[] words) {
        //make a trie of the words and then do word search by the words
        root = new TrieNode();
        populateTrie(words);
        allWords = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char cur = board[i][j];
                if(root.children[cur-'a']!=null){
                    findWords(board,i,j,root);
                }
            }
        }
        return allWords;
    }

    private void findWords(char[][] board, int i, int j, TrieNode node){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'â' ) return;

        char a = board[i][j];
        if(node.children[a-'a'] == null) return;

        node = node.children[a-'a'];

        if(node.isWord == true){
            allWords.add(node.word);
            node.isWord = false;
        }
        
            
        board[i][j] = 'â';
        findWords(board, i+1, j, node);
        findWords(board, i, j+1, node);
        findWords(board, i-1, j, node);
        findWords(board, i, j-1, node);
        board[i][j] = a;
    }

    private void populateTrie(String[] words){
        for(String word:words){
            TrieNode cur = root;
            for(char a: word.toCharArray()){
                if(cur.children[a-'a']==null){
                    cur.children[a-'a'] = new TrieNode();
                }
                cur = cur.children[a-'a'];
            }
            cur.isWord = true;
            cur.word = word;
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;
    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}