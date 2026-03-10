class Trie {

    TrieNode node;

    public Trie() {
        node = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = node;
        for(char a: word.toCharArray()){
            if(cur.children[a-'a'] == null){
                cur.children[a-'a'] = new TrieNode();
            }
            cur = cur.children[a-'a'];
        }
        cur.word = word;
    }
    
    public boolean search(String word) {
        TrieNode cur = node;
        for(char a: word.toCharArray()){
            if(cur.children[a - 'a'] == null){
                return false;
            }
            cur = cur.children[a-'a'];
            if(word.equals(cur.word)) return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = node;
        for(char a: prefix.toCharArray()){
            if(cur.children[a-'a'] == null){
                return false;
            }
            cur = cur.children[a - 'a'];
        }
        return true;
    }
}

class TrieNode{
    String word;
    TrieNode[] children;

    public TrieNode(){
        word = null;
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */