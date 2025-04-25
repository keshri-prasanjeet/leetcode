class Solution {
    public String reverseWords(String s) {
        String[] splitWords = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String space = "";
        for(String word: splitWords){
            if(word.length()>0){
                sb.insert(0, space);
                sb.insert(0, word);
                space = " ";
            }
        }
        return sb.toString();
    }
}