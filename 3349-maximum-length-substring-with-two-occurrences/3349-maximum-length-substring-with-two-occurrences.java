class Solution {
    public int maximumLengthSubstring(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int[] charMap = new int[26];
        int maxSS = 0;
        while(right < len){
            char rightChar = s.charAt(right);
            charMap[rightChar - 'a']++;
            while(charMap[rightChar - 'a'] > 2){
                maxSS = Math.max(maxSS, right -left);
                char leftChar = s.charAt(left);
                charMap[leftChar - 'a']--;
                left++;
            }
            right++;
        }
        return Math.max(maxSS, right-left);
    }
}