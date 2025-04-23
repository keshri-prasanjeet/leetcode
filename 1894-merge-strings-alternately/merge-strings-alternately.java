class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        for(int i=0, j=0;i<len1 || j<len2;i++, j++){
            if(i<len1) sb.append(word1.charAt(i));
            if(j<len2) sb.append(word2.charAt(j));
        }
        return sb.toString();
    }
}