class Solution {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];//all the ASCII chars
        for(char a:"aeiouAEIOU".toCharArray()){
            vowels[a] = true;
        }
        int len = s.length();
        int i = 0;
        int j = len-1;
        char[] word = s.toCharArray();
        while(i<j){
            while(i<j && !vowels[word[i]]){
                i++;
            }
            while(i<j && !vowels[word[j]]){
                j--;
            }
            if(i<j){
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(word);
    }
}