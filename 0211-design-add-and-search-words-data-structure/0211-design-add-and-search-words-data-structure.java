class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(char a: word.toCharArray()){
            if(cur.children[a-'a']==null){
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
        
        if(word.charAt(idx)!= '.'){
            return dfs(word, idx+1, node.children[word.charAt(idx)-'a']);
        }

        else{
            for(TrieNode child: node.children){
                if(child != null){
                    if(dfs(word, idx+1, child) == true) return true;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */