class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;

        for(int i=0;i<word.length();i++){
            char a = word.charAt(i);
            if(cur.children[a-'a'] == null){
                cur.children[a-'a'] = new TrieNode();
            }
            cur = cur.children[a-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
       return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode node){
        if(node == null) return false;

        if(idx == word.length()) return node.isWord;

        char a = word.charAt(idx);
        if(a != '.'){
            return dfs(word, idx+1, node.children[a-'a']);
        }

        for(TrieNode child: node.children){
            if(child != null){
                if(dfs(word, idx+1, child) == true) return true;
            }
        }
        return false;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;

    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */