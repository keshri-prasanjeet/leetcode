class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;

        for(int i=0;i<word.length();i++){
            char a = word.charAt(i);
            if(cur.children[a-'a']==null){
                cur.children[a-'a'] = new TrieNode();
            }
            cur = cur.children[a-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;

        for(int i=0;i<word.length();i++){
            char a = word.charAt(i);
            if(cur.children[a - 'a']==null) return false;
            cur = cur.children[a-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for(int i=0;i<prefix.length();i++){
            char a = prefix.charAt(i);
            if(cur.children[a - 'a']==null) return false;
            cur = cur.children[a-'a'];
        }
        return true;
    }

    
}

class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
        
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */