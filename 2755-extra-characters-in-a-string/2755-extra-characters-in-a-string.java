class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        buildTree(dictionary, root);
        Integer[] memo = new Integer[s.length()];
        return findMinExtraChar(s, root, 0, memo);
    }

    private int findMinExtraChar(String s, TrieNode node, int idx, Integer[] memo){
        if(idx == s.length()) return 0;
        if(memo[idx]!=null) return memo[idx];

        //skip this letter and find matches from next
        int min = 1 + findMinExtraChar(s, node, idx+1, memo);

        //find matches from this index
        TrieNode cur = node;
        for(int i=idx;i<s.length();i++){
            char a = s.charAt(i);
            if(cur.children[a-'a'] == null) break;
            cur = cur.children[a-'a'];

            if(cur.isWord){
                min = Math.min(min, findMinExtraChar(s, node, i+1, memo));
            }
        }
        memo[idx] = min;
        return memo[idx];
    }

    private void buildTree(String[] words, TrieNode root){
        
        for(String word: words){
            TrieNode cur = root;
            for(char c: word.toCharArray()){
                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.isWord = true;
        }
    }
}

class TrieNode{
    boolean isWord;
    TrieNode[] children;

    public TrieNode(){
        this.isWord = false;
        children = new TrieNode[26];
    }
}