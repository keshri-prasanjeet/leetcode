class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[26];
        for(char m: magazine.toCharArray()){
            dictionary[m-'a']++;
        }
        for(char r: ransomNote.toCharArray()){
            dictionary[r-'a']--;
            if(dictionary[r-'a'] < 0) return false;
        }
        return true;
    }
}