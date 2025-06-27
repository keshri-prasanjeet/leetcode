class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        if(s.length() != t.length()) return false;
        for(char a: s.toCharArray()){
            alphabets[a-'a']++;
        }
        for(char a: t.toCharArray()){
            alphabets[a-'a']--;
            if(alphabets[a-'a']<0) return false;
        }
        return true;
    }
}