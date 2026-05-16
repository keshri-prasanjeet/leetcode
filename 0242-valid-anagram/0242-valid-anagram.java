class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        if(sLen != t.length()) return false;

        int[] charSet = new int[26];

        for(int i=0;i<sLen;i++){
            charSet[s.charAt(i)-'a']++;
        }

        for(int i=0;i<sLen;i++){
            int idx = t.charAt(i)-'a';
            charSet[idx]--;
            if(charSet[idx]<0) return false;
        }

        return true;
    }
}