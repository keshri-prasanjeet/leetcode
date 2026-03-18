class Solution {
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        memo = new Integer[s.length()];
        return findMinExtraChars(0, s, root);
    }

    private int findMinExtraChars(int startIdx, String s, TrieNode node){
        if(startIdx == s.length()) return 0;
        if(memo[startIdx]!=null) return memo[startIdx];

        int min = 0;

        //skip and start from the next index
        min = 1 + findMinExtraChars(startIdx+1, s, node);

        //try taking the current index
        TrieNode cur = node;
        for(int i=startIdx;i<s.length();i++){
            char a = s.charAt(i);
            if(cur.children[a-'a'] == null) break;
            cur = cur.children[a-'a'];
            if(cur.isWord){
                //we have found a word
                min = Math.min(min, findMinExtraChars(i+1, s, node));
            }
        }
        memo[startIdx] = min;
        return min;
    }

    private TrieNode buildTrie(String[] dictionary){
        TrieNode root = new TrieNode();

        for(String word: dictionary){
            TrieNode cur = root;
            for(char a : word.toCharArray()){
                if(cur.children[a-'a']==null){
                    cur.children[a-'a'] = new TrieNode();
                }
                cur = cur.children[a-'a'];
            }
            cur.isWord = true;
        }
        return root;
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