class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqCount = new int[26];
        int l = 0;
        int maxWindow = 0;
        int maxAppearedChar = 0;
        for(int r = 0;r<s.length();r++){
            char chR = s.charAt(r);
            freqCount[chR-'A']++;
            maxAppearedChar = Math.max(maxAppearedChar, freqCount[chR-'A']);
            while((r-l+1)-maxAppearedChar > k){
                freqCount[s.charAt(l)-'A']--;
                l++;
            }
            maxWindow = Math.max(maxWindow, r-l+1);
        }
        return maxWindow;
    }
}