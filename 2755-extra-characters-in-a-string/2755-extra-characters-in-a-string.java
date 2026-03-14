class Solution {
    int minExtra;
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        buildTree(dictionary, root);
        memo = new Integer[s.length()];
        return findMinExtra(s, root, 0);
    }

    private int findMinExtra(String s, TrieNode node, int index){
        if(index == s.length()) return 0;

        if(memo[index]!=null) return memo[index];
        
        //skip
        int min = 1 + findMinExtra(s, node, index+1);

        //take if match
        TrieNode cur = node;
        for(int i=index;i<s.length();i++){
            char c = s.charAt(i);
            if(cur.children[c-'a'] == null) break;

            cur = cur.children[c-'a'];

            if(cur.isWord){
                min = Math.min(min, findMinExtra(s, node, i+1));
            }
        }
        memo[index] = min;
        return min;
    }

    private void buildTree(String[] dictionary, TrieNode node){
        if(node == null) return;

        for(String word : dictionary){
            TrieNode cur = node;
            for(char a: word.toCharArray()){
                if(cur.children[a-'a'] == null){
                    cur.children[a-'a'] = new TrieNode();
                }
                cur = cur.children[a-'a'];
            }
            cur.isWord = true;
        }
    }
}

class TrieNode{
    boolean isWord;
    TrieNode[] children;

    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }
}