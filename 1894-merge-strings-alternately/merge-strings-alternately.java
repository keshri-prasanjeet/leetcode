class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i<word1.length() && i<word2.length()){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
            i++;
        }
        str.append(word1.substring(i));
        str.append(word2.substring(i));
        return str.toString();
    }
}