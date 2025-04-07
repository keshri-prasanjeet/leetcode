class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder newWord = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i<len1 || j<len2){
            if(i<len1){
                newWord.append(word1.charAt(i));
                i++;
            }
            if(j<len2){
                newWord.append(word2.charAt(j));
                j++;
            }
        }

        return newWord.toString();
    }
}